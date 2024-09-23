plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)

}

android {
    namespace = "com.example.cards"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.cards"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.recyclerview)
    val nav_version = "2.8.1"
    implementation("androidx.navigation:navigation-compose:$nav_version")
    implementation("androidx.navigation:navigation-fragment:$nav_version")
    implementation("androidx.navigation:navigation-ui:$nav_version")
    implementation("androidx.navigation:navigation-dynamic-features-fragment:$nav_version")
    androidTestImplementation("androidx.navigation:navigation-testing:$nav_version")
    implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation ("com.github.rubensousa:gravitysnaphelper:2.2.2")
    implementation ("androidx.navigation:navigation-fragment-ktx:<version>")
    implementation ("androidx.navigation:navigation-ui-ktx:<version>")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("androidx.core:core-ktx:1.10.1")
    implementation ("androidx.recyclerview:recyclerview:1.3.0")
    implementation ("com.google.android.material:material:1.9.0")
    implementation ("com.github.rubensousa:gravitysnaphelper:2.2.2")
    implementation ("com.github.sparrow007:carouselrecyclerview:1.2.6")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}