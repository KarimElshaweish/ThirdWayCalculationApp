package com.karim.thirdwaycalculationapp.View

import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.karim.thirdwaycalculationapp.Adapter.GrideAdapter
import com.karim.thirdwaycalculationapp.Operations.Calcultoin
import com.karim.thirdwaycalculationapp.R
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    var op=""
    var lastOperation=""
    lateinit var items:ArrayList<String>
    lateinit var operationStack: Stack<Pair<String,String>>
    lateinit var operationRedo:Stack<Pair<String,String>>
    lateinit var gridAdapter:GrideAdapter
    var nightMode=false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        operationStack= Stack()
        operationRedo=Stack()
        items= ArrayList()
        changeColorModeSwitch.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            nightMode = isChecked
            chnageMode()
        })
    }


    /**
     *
     * This function is used to change the colors of the application
     * depend on the switch value
     */
    private fun chnageMode() {
        var currentModeColorPrimary=resources.getColor(R.color.white)
        if(nightMode)
            currentModeColorPrimary=resources.getColor(R.color.dark_color)
        result.setBackgroundColor(currentModeColorPrimary)
        allToolsContainer.setBackgroundColor(currentModeColorPrimary)
        gridView.setBackgroundColor(currentModeColorPrimary)
    }

    /**
     * This function is the all onClick actions in the all application
     * ... which depend on the text inside the view
     *.... if the text -> UNDO
     * ........ we pop the last operation in the operation  stack and put it to the redo stack
     * .... if the text -> REDO
     * ......... we pop last operation in the undo stack and put it to the operation stack
     * ..... if the text -> "="
     * ........ we check either the op variable which contain the current operation is empty or
     *          no if not we check the entered number of the user if exist then we run evaluate  function
     * ....... else we save the view text to the op variable
     * @param view which is current clickable tool in the UI.
     */
    fun buttonClick(view:View){
        val buttonTextView=view as TextView
        val buttonTextVal=buttonTextView.text.toString()
        when(buttonTextView.text){
            "UNDO"-> {
                if (items.size == 0)
                    Toast.makeText(this, "No past operation", Toast.LENGTH_SHORT).show()
                else {
                    items.removeAt(items.size - 1)
                    gridAdapter = GrideAdapter(this, R.layout.custome_gride_item, items)
                    gridView.adapter = gridAdapter
                    if (operationStack.size > 0)
                        operationRedo.push(operationStack.pop())
                    if (operationStack.size > 0)
                        result.text = operationStack.peek().second
                    else
                        result.text = "0"
                }
            }
            "REDO"->{
                val pair=operationStack.push(operationRedo.pop())
                items.add(pair.first)
                result.text=pair.second
                gridAdapter= GrideAdapter(this, R.layout.custome_gride_item,items)
                gridView.adapter=gridAdapter
            }
            "="->{
                val sNumberText=sNumber.text.toString()
                when {
                    sNumberText == "" -> Toast.makeText(this,"please enter the second number",Toast.LENGTH_SHORT).show()
                    op=="" -> Toast.makeText(this,"please chose an operation",Toast.LENGTH_SHORT).show()
                    else -> {
                        evaluate(result.text.toString(), sNumberText)
                        changeAllTextViewsColor(buttonTextView)
                    }
                }
            }
            else ->{
                view.background=(ContextCompat.getDrawable(this, R.drawable.selcted_text_view) );
                view.setTextColor(resources.getColor(R.color.white))
                changeAllTextViewsColor(view)
                op=buttonTextVal
            }
        }
    }

    /**
     * This function is used to  change the other tools
     * color when one clicked and return it the default theme
     */
    private fun changeAllTextViewsColor(view: TextView){
        when(view.id){
            R.id.plusTextView ->{
                changeOneViewBackground(subtractionTextView)
                changeOneViewBackground(divisonTextView)
                changeOneViewBackground(multplicationTextView)
            }
            R.id.subtractionTextView ->{
                changeOneViewBackground(plusTextView)
                changeOneViewBackground(divisonTextView)
                changeOneViewBackground(multplicationTextView)
            }
            R.id.multplicationTextView ->{
                changeOneViewBackground(subtractionTextView)
                changeOneViewBackground(divisonTextView)
                changeOneViewBackground(plusTextView)
            }
            R.id.divisonTextView ->{
                changeOneViewBackground(subtractionTextView)
                changeOneViewBackground(plusTextView)
                changeOneViewBackground(multplicationTextView)
            }
            else ->{
                changeOneViewBackground(subtractionTextView)
                changeOneViewBackground(plusTextView)
                changeOneViewBackground(multplicationTextView)
                changeOneViewBackground(divisonTextView)
            }
        }
    }

    /**
     * This function is used to change the background to be inactive
     */
    private fun changeOneViewBackground(view: TextView){
        view.background=(ContextCompat.getDrawable(this, R.drawable.tools_text_view_design) );
        view.setTextColor(resources.getColor(R.color.orange))
    }

    /**\
     * this function is used to check the operation and
     * call the specific method from the calculation class
     * which set the result to the application UI
     *
     * and put every formula and result in pair
     * and push it the operation stack
     *
     * save every input number with the operation to the grid view
     */
   private fun evaluate(fNumber:String,SNumber:String){
        when(op){
            "+"->{
                result.text= Calcultoin.sum(fNumber.toDouble(), SNumber.toDouble())
            }
            "-"->{
                result.text= Calcultoin.subtraction(fNumber.toDouble(), SNumber.toDouble())
            }
            "*"->{
                result.text= Calcultoin.multiplication(fNumber.toDouble(), SNumber.toDouble())
            }
            "/"->{
                result.text= Calcultoin.division(fNumber.toDouble(), SNumber.toDouble())
            }
        }
       sNumber.setText("")
       lastOperation=op+SNumber
       val pair:Pair<String,String> = Pair(lastOperation,result.text.toString())
       operationStack.push(pair)
        op=""
       items.add(lastOperation)
       gridAdapter= GrideAdapter(this, R.layout.custome_gride_item,items)
       gridView.adapter=gridAdapter
    }
}