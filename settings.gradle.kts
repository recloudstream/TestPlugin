rootProject.name = "TestPlugin"

buildscript {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven("https://jitpack.io")
        //maven("https://maven.pkg.github.com/recloudstream/gradle")
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.0.4")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.30")
        classpath("com.github.recloudstream:gradle:master-SNAPSHOT")
    }
}
