# ListenToAStory
Musical Structure App, Project 4 for the Udacity ABND Scholarship EMEA region by Google 2017/2018.

This is an audiobook player. It consists of three screen - page :
the home screen (MainActivity), the library screen (Library Activity) and the now playing (NowPlaying Activity).

From the home screen of the MainActivity it is possible to navigate to the Library screen by clicking
clickable "Library" TextView thus sending an explicit intent.
By clicking the clickable TextViews with black text send an implicit intent,
performing respectively a web search or going to specific web pages (LibriVox home page and Wikipedia page on Aesop).

The library screen, contains a list of "Fable" objects each containing an audio file with an Aesop fable.
The audiofiles are taken from Aesop's fable (26-50), vol.2 recordings taken from LibriVox.
Clicking a list item on the Library Activity will send an explicit intent to open the NowPlaying activity,
where it will be possible to listen to the chosen fable.

The NowPlaying has a MediaPlayer object which gains Audiofocus and is initialised to play the chosen fable by clicking
the play button.
On playback completed MediaPlayer resource is cleaned and audio focus abandoned.

Up button in LibraryActivity and NowPlayingActivity to go to to the parent activity.

Load a web page sending an implicit intent
				https://developer.android.com/guide/components/intents-common#Browser

Perform a web search sending an implicit intent:
				https://developer.android.com/guide/components/intents-common#SearchWeb
				
Up button learned on the Android Developer training page on "Providing Up navigation":
http://developer.android.com/design/patterns/navigation.html

To implement the mediaplayer seekbar I found advice on:
https://www.google.it/amp/s/mobikul.com/show-seekbar-media-player/amp/
https://www.tutorialspoint.com/android/android_mediaplayer.htm

Released mediaplayer method from "Cleaning Up MediaPlayer Resources" from Udacity course MultiscreenApp (part 17 of Lesson 8).

To change color of list item divider in activity_library.xml:
https://stackoverflow.com/questions/2372415/how-to-change-color-of-android-listview-separator-line

Butter Knife from Jake Wharton to bind views.
http://jakewharton.github.io/butterknife/
Copyright 2013 Jake Wharton


Aesop-s Fable volume 2 taken from LibriVox.
On Librivox you can find free public domain audiobooks read by volunteers around the world.
You can discover new books, become a volunteer reader or just know more about LibriVox on:
				https://librivox.org/
				
Wikipedia the free encyclopedia
				https://en.wikipedia.org/wiki/Main_Page
				
To fix: save MediaPlayer playback on screen rotation
				
