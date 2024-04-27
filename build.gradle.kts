plugins {
    kodein.root
}

allprojects {
    group = "org.kodein.emoji"
    version = "1.3.0"
}

allprojects {
    tasks.configureEach {
        if (name == "kotlinStoreYarnLock") enabled = false
    }

    apply<MavenPublishPlugin>()
    extensions.getByType<PublishingExtension>().apply {
        repositories {
            maven {
                name = "GitHubPackages"
                setUrl("https://maven.pkg.github.com/cbruegg/Emoji.kt")
                credentials {
                    username = System.getenv("GITHUB_ACTOR")
                    password = System.getenv("GITHUB_TOKEN")
                }
            }
        }
    }

}