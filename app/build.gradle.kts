plugins {
	id("com.android.application")
	id("org.jetbrains.kotlin.android")
}

android {
	namespace = "kayel.app.katz"
	compileSdk = 34
	
	defaultConfig {
		applicationId = "kayel.app.katz"
		minSdk = 27
		targetSdk = 34
		versionCode = 1
		versionName = "1.0"
		
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		vectorDrawables {
			useSupportLibrary = true
		}
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
		sourceCompatibility = JavaVersion.VERSION_11
		targetCompatibility = JavaVersion.VERSION_11
	}
	
	kotlinOptions {
		jvmTarget = "11"
	}
	
	buildFeatures {
		compose = true
	}
	
	composeOptions {
		kotlinCompilerExtensionVersion = "1.4.3"
	}
	
	packagingOptions {
		@Suppress("DEPRECATION")
		exclude("META-INF/gradle/incremental.annotation.processors")
		resources.excludes.add("META-INF/*")
	}
	buildToolsVersion = "34.0.0"
}

dependencies {
	
	with("androidx") {
		
		val core = "$this.core"
		implementation("$core:core-ktx:1.12.0")
		
		val activity = "$this.activity"
		implementation("$activity:activity-compose:1.8.0")
		
		val navigation = "$this.navigation"
		implementation("$navigation:navigation-compose:2.7.4")
		
		val lifecycle = "$this.lifecycle:lifecycle"
		"2.6.2".let {
			implementation("$lifecycle-runtime-ktx:$it")
			implementation("$lifecycle-viewmodel-compose:$it")
			implementation("$lifecycle-runtime-compose:$it")
		}
		
		val compose = "$this.compose"
		"1.5.4".let {
			implementation("$compose.ui:ui-graphics:$it")
			implementation("$compose.ui:ui:$it")
			implementation("$compose.runtime:runtime:$it")
			implementation("$compose.runtime:runtime-livedata:$it")
			implementation("$compose.foundation:foundation:$it")
			implementation("$compose.foundation:foundation-layout:$it")
			implementation("$compose.material:material:$it")
			implementation("$compose.material3:material3:1.1.2")
			androidTestImplementation("$compose.ui:ui-test-junit4:$it")
		}
	}
	
	val retrofit = "com.squareup.retrofit2"
	"2.9.0".let {
		implementation("$retrofit:retrofit:$it")
		implementation("$retrofit:converter-gson:$it")
	}
	
	val coil = "io.coil-kt"
	implementation("$coil:coil-compose:2.4.0")
	
	val mockk = "io.mockk"
	implementation("$mockk:mockk:1.13.8")
	
	implementation("com.google.android.engage:engage-core:1.3.1")
	
	implementation("com.google.dagger:hilt-android:2.48.1")
	
	implementation("com.google.dagger:hilt-compiler:2.39")
	
	testImplementation("junit:junit:4.13.2")
	testImplementation("io.mockk:mockk:1.13.8")
	testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
	androidTestImplementation("androidx.test.ext:junit:1.1.5")
	androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
	androidTestImplementation("androidx.arch.core:core-testing:2.2.0")
}
