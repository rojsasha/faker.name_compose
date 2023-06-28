dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}



rootProject.name = "FakerName"
include (":app")
include(":common:compose")
include(":common:imageloading")
include(":common:resources")
include(":data")
include(":domain")
include(":ui:search")
include(":base")
include(":model")
