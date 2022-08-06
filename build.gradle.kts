plugins {
    id("com.android.library")
    id("kotlin-android")
    id("com.lagradost.cloudstream3.gradle")
}


version = "1.0.0"

cloudstream {

}

repositories {
    maven("https://jitpack.io")
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
    implementation(kotlin("stdlib", kotlin.coreLibrariesVersion))
    implementation("com.github.Blatzar:NiceHttp:0.3.2")
    implementation("org.jsoup:jsoup:1.13.1")
}
