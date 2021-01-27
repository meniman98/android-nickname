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
