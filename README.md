# Welcome
This app is a demonstration of how data binding works. Go ahead fork it, (or download it) and insert your nickname. The app will greet you.
Additionally there is a legendary bio description at the bottom and once you fill in your nickname, your name will appear in the bio

# Point of the app
The point is to demonstrate how data binding, string concatenation and models work in Android. Lets go ahead and explain how each of them work

## Data binding
To use data binding, do the following in steps
### Steps
1. Enable data binding within the app gradle by using ```dataBinding { enabled = true }``` 
2. In your xml layout, wrap all views in a ```<layout> </layout>``` tag. Even your constraint layout. Be sure to give your constraint/linear layout an ID
3. Navigate to your Activity.kt/java file and initialise a binding variable by using ```private lateinit var binding: ActivityMainBinding```. If you're using Java, go ahead
and use ```private ActivityMainBinding binding```
4. Remove the setContentView method and instead use ```binding = DataBindingUtil.setContentView(this, R.layout.activity_main)``` should be the same for Java
5. Now you can use any view by remembering its ID like so ```binding.myTextView``` or ```binding.myPurpleButton``` and use it for functions like 
```binding.myTextView.setText("hello there")``` or do something like ```binding.myPurpleButton.setOnClickListener() { ello() }```. One cool thing you can do is
use the ```binding.apply { //logic here }``` which allows you to directly reference the ID of views without the binding keyword like so 
```
binding.apply {
myTextView.setText("Hello there")
myPurpleButton.setOnClickListener() { ello() }
}
```

### Using a model within your xml layout
1. Create a tag 
```
<data>
  <variable>
    name = "myDataModel"
    type = "com.example.nickname.MyName"
  </variable>
</data>
``` 
myDataModel is your object, so myDataModel.firstName or myDataModel.lastName will work. "name" is simply the name of your object. The "MyName" is the class of your model. 
If you're using Kotlin (which you should) it'll be a data class, if you're using Java then it's a class


2. Lets use the myDataModel.firstName in a textview. This is how ```android:text='@{"Hello there " + myDataModel.firstName}' ``` Now this will appear as
"Hello there Huncho" on the textview, pretty cool! You've now used a property from an object within a textview, rather than hard coding it. For many reasons, this approach
is far better than hard coding a string


3. To concatenate strings within strings.xml, you use ``` android:text="@{@string/bio(myDataModel.firstName)}" ``` then at the same time set your string in strings.xml
to something like ``` <string name="bio">Hello there %1$s, how is your day going? ``` This allows your strings to be dynamic and allow concatenation to be done

### Making a data model
In Kotlin, the code to make a data class is something like
```
data class MyName(
    var defaultName: String = "Travis Scott"
)
```
You can either leave the string empty by doing ```String = "" ``` or fill in a default value. Kotlin won't accept it if you leave it unassigned, so something like this
``` var defaultName: String ``` wouldn't work. Pretty annoying I guess. In Java, it is possible to leave object variables unassigned. I assume Kotlin doesn't like to it because
it could cause null reference errors
