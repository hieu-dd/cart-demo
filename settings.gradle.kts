val usePrebuiltLibraries: Boolean
get() {

    val properties = java.util.Properties().apply {
        val propertiesFile = File("project.properties")
        if (propertiesFile.exists()) {
            load(propertiesFile.inputStream())
        } else throw NoSuchFieldException("Not defined file Name: project.properties")
    }

    return properties.getProperty("usePrebuiltLibraries")?.toBoolean() ?: true
}

include(
        ":app",
        ":apollo:apollo",

        //android framework
        // android framework
        ":android-framework:data",
        ":android-framework:logging",
        ":android-framework:framework",
        ":android-framework:util",
        ":android-framework:util-android",
        ":android-framework:notification",
        ":android-framework:service",
        ":android-framework:ui",
        ":android-framework:testutil"
)

rootProject.name = "CartSDKs Demo"

if (!usePrebuiltLibraries) {
    include(
            // android framework
            ":android-framework:data",
            ":android-framework:logging",
            ":android-framework:framework",
            ":android-framework:util",
            ":android-framework:util-android",
            ":android-framework:notification",
            ":android-framework:ui",

            //terra
            ":terra:terra-core:terra-core-android"

    )
}


if (!usePrebuiltLibraries) {
    project(":android-framework:util").projectDir =
            File(rootProject.projectDir, "./terra/android-framework/util")

    project(":android-framework:util-android").projectDir =
            File(rootProject.projectDir, "./terra/android-framework/util-android")

    project(":android-framework:data").projectDir =
            File(rootProject.projectDir, "./terra/android-framework/data")
    project(":android-framework:ui").projectDir =
            File(rootProject.projectDir, "./terra/android-framework/ui")

    project(":android-framework:framework").projectDir =
            File(rootProject.projectDir, "./terra/android-framework/framework")

    project(":terra:terra-core:terra-core-android").projectDir =
            File(rootProject.projectDir, "./terra/terra-core/terra-core-android")

    project(":android-framework:notification").projectDir =
            File(rootProject.projectDir, "./terra/android-framework/notification")

    project(":android-framework:logging").projectDir =
            File(rootProject.projectDir, "./terra/android-framework/logging")

    project(":android-framework:ui").projectDir =
            File(rootProject.projectDir, "./terra/android-framework/ui")

}
