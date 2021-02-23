import dependencies.*

plugins {
    `shared-android-library`
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.KOTLIN_ANDROID_EXTENSIONS)

}

android {
    defaultConfig {
        vectorDrawables.useSupportLibrary = BuildAndroidConfig.SUPPORT_VECTOR_DRAWABLE
    }
}

dependencies {
    api(project(":cart:cart-core"))
    api(project(":cart:cart-bus"))
    implementation(project(":terra:terra-core:terra-core-android"))

    implementation(Dependencies.GLIDE)

    kapt(AnnotationProcessorsDependencies.GLIDE_COMPILER)
    kapt(AnnotationProcessorsDependencies.DAGGER_COMPILER)
    kapt(AnnotationProcessorsDependencies.DAGGER_ANDROID_PROCESSOR)


    implementation(Dependencies.GSON)

    testImplementation(TestDependencies.JUNIT)
    testImplementation(TestDependencies.COROUTINE_TEST)

    androidTestImplementation(TestAndroidDependencies.JUNIT)
    androidTestImplementation(TestAndroidDependencies.ESPRESSO)

}