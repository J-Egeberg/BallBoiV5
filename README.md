# Article - Fragments

This Article is created by Casper Gross Larsen and Jens Egeberg Rasmussen. By reading this article you will learn about Fragments and the use of these in our own little school project. But before we can dive into What fragments are, we are gonna talk a little about where fragments are used: in Android-App-Development.

Ano 2018 we are quite sure that everyone knows what an app is. App stands for application and is used as both web-app, desktop-app and mobile-apps. Mobile-apps is where we have been working via android studio which is a tool for creating android-mobile-apps. 

When you, as a user, open an app, what you see is the apps interface. This interface is probably filled buttons, text and other gadgets. This is an interface for android studio code. And this interface is presented by what is called an activity.

An activity is considered one of the fundamental building blocks of app on an android platform. This is where the user interact with the app, and also servers as a navigator within an app (the back button, and Recents button serves as examples by this). The activity has a lifecycle in which when the user clicks around on the app, the state of the activity changes within the same lifecycle. When the app closes the lifecycle ends but data can still be stored. For instance if you are watching a video on youtube on your phone, and you pause and leave youtube the lifecycle will save the state from which you left the app and will resume next time u enter the app and be ready to continue from where you left off.

Another way to navigate through your activity is by the use of fragments.

A fragment is usually used as part of an activity's user interface and contributes its own layout (User Interface) to the activity. To provide a layout for a fragment, you must implement the onCreateView() callback method, which the Android system calls when it's time for the fragment to draw its layout. A Fragment can be called a sub Activity.

Fragments are used to create more dynamic and flexible UI designs on larger screens, such as tablets. The larger screen makes more room to combine and interchange UI components (fragments). Fragments allow such designs without the need to manage and save thecomplex changes in the activity. By dividing the Activity into fragments you will be able to modify the activity's appearance at runtime and preserve and save changes in the back, because it is all in the same activity.
What is the purpose of Fragments?

For example, a news application can use one fragment to show a list of articles on the left and another fragment to display an article on the right—both fragments appear in one activity, side by side, and each fragment has its own set of lifecycle callback methods and handle their own user input events. Thus, instead of using one activity to select an article and another activity to read the article, the user can select an article and read it all within the same activity.

Each fragment should be designet as a modular and reusable activity component. That is because a fragment defines its own layout (User interface) and its own behavior within its own lifecycle and callbacks (code methods used to change the state). Each fragment can be included in multiple activities so the design should be reusable. 

This is especially important because a modular fragment allows you to change your fragment combinations for different screen sizes. When designing your application to support both tablets and handsets, you can reuse your fragments in different layout configurations to optimize the user experience based on the available screen space. For example, on a handset, it might be necessary to separate fragments to provide a single-pane UI when more than one cannot fit within the same activity.

Alternativvely in Android Development you can use the Activity. The activity is able to navigate throughout the app aswell and multiple activities can be swapped, however only one activity can be viewed at a time. while multiple fragments can be viewed from within an activity.

The main reason to use Fragments are for the backstack and lifecycle features. Otherwise, custom views are more light weight and simpler to implement. By using fragments we are able to save the state and benefit from lifecycle features. Another great reason for the use of fragments is its 

-------------------------------------
Summing up our school project:
We are creating a mobile android app in which you can create and login as a user. The user can then choose from a wide variety of recipes or add another recipe for other people to enjoy.

How will we use Fragments in our project?
In our school project we have decided to use fragments for navigational purposes. The navigation (fragments) is all happening within the Main Activity and is swapped when clicking around on the app by our class SectionStatePagerAdapter (look photo below). We are doin this because we want to save info in the overall activity from a logged in user.

![alt text](https://github.com/J-Egeberg/BallBoiV5/blob/master/FragmentManager.png)




Navigator
Saving User information

Why are we using fragments in our project?

Evaluate: How did our use of fragments go?

Was using Fragments the right solution for our project?

o You must explain the purpose of the tech, the advantages of using it and what (if any)
alternatives exist.
o Explain how you intend to use the tech in your article
o Describe your solution – what did you do and why?
o Evaluate your solution – how did it go?
o Conclusion – Do you recommend the solution and what did you learn
 You must make an android project with a solution about the topic, demonstrating that you had
hands on experience on the topic. The ambition level is prototype level – not a perfect project. The
code must be well made, so include comments and proper formatting. A few topics are more
theoretical, and thus may get exemption from handing in code, while other projects may be less
interesting to describe textually, thus requiring more code effort.
