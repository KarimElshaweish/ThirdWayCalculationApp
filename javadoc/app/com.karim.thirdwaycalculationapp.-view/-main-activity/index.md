[app](../../index.md) / [com.karim.thirdwaycalculationapp.View](../index.md) / [MainActivity](./index.md)

# MainActivity

`class MainActivity : AppCompatActivity`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MainActivity()` |

### Properties

| Name | Summary |
|---|---|
| [gridAdapter](grid-adapter.md) | `lateinit var gridAdapter: `[`GrideAdapter`](../../com.karim.thirdwaycalculationapp.-adapter/-gride-adapter/index.md) |
| [items](items.md) | `lateinit var items: `[`ArrayList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-array-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [lastOperation](last-operation.md) | `var lastOperation: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [nightMode](night-mode.md) | `var nightMode: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [op](op.md) | `var op: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [operationRedo](operation-redo.md) | `lateinit var operationRedo: `[`Stack`](https://developer.android.com/reference/java/util/Stack.html)`<`[`Pair`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>>` |
| [operationStack](operation-stack.md) | `lateinit var operationStack: `[`Stack`](https://developer.android.com/reference/java/util/Stack.html)`<`[`Pair`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>>` |

### Functions

| Name | Summary |
|---|---|
| [buttonClick](button-click.md) | `fun buttonClick(view: `[`View`](https://developer.android.com/reference/android/view/View.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>This function is the all onClick actions in the all application ... which depend on the text inside the view .... if the text -&gt; UNDO ........ we pop the last operation in the operation  stack and put it to the redo stack .... if the text -&gt; REDO ......... we pop last operation in the undo stack and put it to the operation stack ..... if the text -&gt; "=" ........ we check either the op variable which contain the current operation is empty or     no if not we check the entered number of the user if exist then we run evaluate  function ....... else we save the view text to the op variable |
| [onCreate](on-create.md) | `fun onCreate(savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
