[app](../../index.md) / [com.karim.thirdwaycalculationapp.View](../index.md) / [MainActivity](index.md) / [buttonClick](./button-click.md)

# buttonClick

`fun buttonClick(view: `[`View`](https://developer.android.com/reference/android/view/View.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

This function is the all onClick actions in the all application
... which depend on the text inside the view
.... if the text -&gt; UNDO
........ we pop the last operation in the operation  stack and put it to the redo stack
.... if the text -&gt; REDO
......... we pop last operation in the undo stack and put it to the operation stack
..... if the text -&gt; "="
........ we check either the op variable which contain the current operation is empty or
    no if not we check the entered number of the user if exist then we run evaluate  function
....... else we save the view text to the op variable

### Parameters

`view` - which is current clickable tool in the UI.