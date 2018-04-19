# BallBoiV5

Requirements details:
 You must write and explain the topic in your article, you can use charts and illustrations. It must be
4-6 pages.
o You must introduce the technology/plugin and explain it as if the reader doesn’t know
anything about it.

Zoom in Overall:
## Article - Fragments

Purpose of Article

This Article is created by Casper Gross Larsen and Jens Egeberg Rasmussen. By reading this article you will learn about Fragments and the use of these in our own little school project. But before we can dive into What fragments are, we are gonna talk a little about where fragments are used: in Android-App-Development.

Ano 2018 we are quite sure that everyone knows what an app is. App stands for application and is used as both web-app, desktop-app and mobile-apps. Mobile-apps is where we have been working via android studio which is a tool for creating android-mobile-apps. 

When you, as a user, open an app, what you see is the apps interface. This interface is probably filled buttons, text and other gadgets. This is an interface for android studio code. And this interface is presented by what is called an activity.

An activity is considered one of the fundamental building blocks of app on an android platform. This is where the user interact with the app, and also servers as a navigator within an app (the back button, and Recents button serves as examples by this). The activity has a lifecycle in which when the user clicks around on the app, the state of the activity changes within the same lifecycle. When the app closes the lifecycle ends but data can still be stored. For instance if you are watching a video on youtube on your phone, and you pause and leave youtube the lifecycle will save the state from which you left the app and will resume next time u enter the app and be ready to continue from where you left off.

Another way to navigate through your activity is by the use of fragments.

A fragment is usually used as part of an activity's user interface and contributes its own layout to the activity. To provide a layout for a fragment, you must implement the onCreateView() callback method, which the Android system calls when it's time for the fragment to draw its layout.

https://developer.android.com/guide/components/fragments.html

What is the purpose of Fragments?

Android introduced fragments in Android 3.0 (API level 11), primarily to support more dynamic and flexible UI designs on large screens, such as tablets. Because a tablet's screen is much larger than that of a handset, there's more room to combine and interchange UI components. Fragments allow such designs without the need for you to manage complex changes to the view hierarchy. By dividing the layout of an activity into fragments, you become able to modify the activity's appearance at runtime and preserve those changes in a back stack that's managed by the activity. They are now widely available through the fragment support library.

For example, a news application can use one fragment to show a list of articles on the left and another fragment to display an article on the right—both fragments appear in one activity, side by side, and each fragment has its own set of lifecycle callback methods and handle their own user input events. Thus, instead of using one activity to select an article and another activity to read the article, the user can select an article and read it all within the same activity, as illustrated in the tablet layout in figure 1.

You should design each fragment as a modular and reusable activity component. That is, because each fragment defines its own layout and its own behavior with its own lifecycle callbacks, you can include one fragment in multiple activities, so you should design for reuse and avoid directly manipulating one fragment from another fragment. This is especially important because a modular fragment allows you to change your fragment combinations for different screen sizes. When designing your application to support both tablets and handsets, you can reuse your fragments in different layout configurations to optimize the user experience based on the available screen space. For example, on a handset, it might be necessary to separate fragments to provide a single-pane UI when more than one cannot fit within the same activity.

What is the alternative?

Just using activities

What is the benefits?

-------------------------------------

How will we use Fragments in our project?

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
