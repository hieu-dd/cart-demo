import extensions.gitlabTeko

buildscript {

    repositories {
        google()
        jcenter()
        mavenCentral()
        maven(url = "https://maven.fabric.io/public")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${BuildDependenciesVersions.GRADLE}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${BuildDependenciesVersions.KOTLIN}")
        classpath("com.google.gms:google-services:${BuildDependenciesVersions.GOOGLE_SERVICES}")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${BuildDependenciesVersions.NAVIGATION}")
        classpath("junit:junit:${BuildDependenciesVersions.JUNIT}")
    }
}

allprojects {
    repositories {
        google()
        jcenter()

        gitlabTeko(project = this@allprojects)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
