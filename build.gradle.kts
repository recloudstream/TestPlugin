plugins {
    id("com.android.library")
    id("kotlin-android")
    id("com.lagradost.cloudstream3.gradle")
}


version = "1.0.0"

cloudstream {

}

android {
    compileSdk = 30

    defaultConfig {
        minSdk = 24
        targetSdk = 30
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

repositories {
    google()
    mavenCentral()
    mavenLocal()
    //maven("https://maven.pkg.github.com/recloudstream/gradle")
//    maven("https://jitpack.io")
}

dependencies {
    apk("com.lagradost:cloudstream3:pre-release")
}
