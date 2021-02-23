import dependencies.Dependencies
import dependencies.TestDependencies
import plugins.`shared-android-library`

plugins {
    `shared-android-library`
    id(BuildPlugins.KOTLIN_KAPT)
}

dependencies {
    api(project(":cart:cart-core"))
    implementation(project(":terra:terra-core:terra-core-android"))

    implementation(Dependencies.GSON)

    testImplementation(TestDependencies.JUNIT)
    testImplementation(TestDependencies.MOCKITO_CORE)
    testImplementation(TestDependencies.COROUTINE_TEST)
}