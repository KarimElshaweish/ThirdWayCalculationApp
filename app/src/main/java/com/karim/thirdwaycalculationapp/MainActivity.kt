package com.karim.thirdwaycalculationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.karim.thirdwaycalculationapp.Adapter.GrideAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    var op=""
    var lastOperation=""
    lateinit var items:ArrayList<String>
    lateinit var operationStack: Stack<Pair<String,String>>
    lateinit var operationRedo:Stack<Pair<String,String>>
    lateinit var gridAdapter:GrideAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        operationStack= Stack()
        operationRedo=Stack()
        items= ArrayList()
    }
     fun buttonClick(view:View){
        val buttonTextView=view as TextView
        val buttonTextVal=buttonTextView.text.toString()
        when(buttonTextView.text){
            "Undo"-> {
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
            "Redo"->{
                val pair=operationStack.push(operationRedo.pop())
                items.add(pair.first)
                result.text=pair.second
                gridAdapter= GrideAdapter(this,R.layout.custome_gride_item,items)
                gridView.adapter=gridAdapter
            }
            "="->{
                evaluate(result.text.toString(),sNumber.text.toString())
            }
            else ->{
                op=buttonTextVal
            }
        }
    }


   private fun evaluate(fNumber:String,SNumber:String){
        when(op){
            "+"->{
                result.text=Calcultoin.sum(fNumber.toDouble(),SNumber.toDouble())
            }
            "-"->{
                result.text=Calcultoin.subtraction(fNumber.toDouble(),SNumber.toDouble())
            }
            "*"->{
                result.text=Calcultoin.multiplication(fNumber.toDouble(),SNumber.toDouble())
            }
            "/"->{
                result.text=Calcultoin.division(fNumber.toDouble(),SNumber.toDouble())
            }
        }
       sNumber.setText("")
       lastOperation=op+SNumber
       val pair:Pair<String,String> = Pair(lastOperation,result.text.toString())
       operationStack.push(pair)
        op=""
       items.add(lastOperation)
       gridAdapter= GrideAdapter(this,R.layout.custome_gride_item,items)
       gridView.adapter=gridAdapter
    }
}