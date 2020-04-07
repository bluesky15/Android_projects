// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    //ext.kotlin_version = "1.3.61"
    repositories {
        jcenter()
        google()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.1.0-alpha04")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.70")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        jcenter()
        google()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
