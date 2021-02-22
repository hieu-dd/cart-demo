import dependencies.AnnotationProcessorsDependencies
import dependencies.Dependencies
import dependencies.TekoDependencies
import dependencies.TestDependencies

plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.KOTLIN_ANDROID_EXTENSIONS)
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.NAVIGATION_SAFE_ARGS)
}

android {
    compileSdkVersion(BuildAndroidConfig.COMPILE_SDK_VERSION)
    buildToolsVersion(BuildAndroidConfig.BUILD_TOOLS_VERSION)

    defaultConfig {
        applicationId = BuildAndroidConfig.APPLICATION_ID
        minSdkVersion(BuildAndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(BuildAndroidConfig.TARGET_SDK_VERSION)
        versionCode = System.getenv("GITHUB_RUN_ID")
            ?.toInt() ?: BuildAndroidConfig.VERSION_CODE
        versionName = BuildAndroidConfig.VERSION_NAME

        testInstrumentationRunner = BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER

        multiDexEnabled = BuildAndroidConfig.MULTIDEX_ENABLED

        vectorDrawables.useSupportLibrary = true

        javaCompileOptions {
            annotationProcessorOptions.includeCompileClasspath = true
        }
    }

    buildTypes {
        getByName("release") {
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")

            isMinifyEnabled = false
        }

        getByName("debug") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }


    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    dataBinding {
        isEnabled = true
    }
}

dependencies {
    implementation(
        fileTree(
            mapOf(
                "dir" to "libs",
                "include" to listOf("*.jar")
            )
        )
    )
    implementation(project(":apollo:apollo"))

    if (BuildAndroidConfig.USE_PREBUILT_LIBRARIES) {
        api(TekoDependencies.TERRA_CORE_ANDROID)
    } else {
        api(project(BuildModules.TERRA_CORE_ANDROID))
    }

    // navigation
    implementation(Dependencies.NAVIGATION)
    implementation(Dependencies.NAVIGATION_UI)

    testImplementation(TestDependencies.TEST_EXT)
    testImplementation(TestDependencies.TEST_TRUTH)
    testImplementation(TestDependencies.ARCH_TESTING)
    testImplementation(TestDependencies.TEST_RUNNER)
    testImplementation(TestDependencies.MOCKITO_CORE)
    testImplementation(TestDependencies.MOCKITO_INLINE)
    testImplementation(TestDependencies.ROBOLECTRIC)
    testImplementation(TestDependencies.MOCK_WEB_SERVER)
    testImplementation(TestDependencies.WORK_TEST)
    testImplementation(TestDependencies.ESPRESSO_CORE)
    testImplementation(TestDependencies.ESPRESSO_INTENT)
    testImplementation(TestDependencies.ESPRESSO_CONTRIB)
    testImplementation(TestDependencies.COROUTINE_TEST)

    kapt(AnnotationProcessorsDependencies.DAGGER_COMPILER)
    kapt(AnnotationProcessorsDependencies.DAGGER_ANDROID_PROCESSOR)

    // Map Struct
    api(Dependencies.MAP_STRUCT)
    api(Dependencies.MAP_STRUCT_KOTLIN_BUILDER)
    kapt(AnnotationProcessorsDependencies.MAP_STRUCT_PROCESSOR)


}