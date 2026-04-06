plugins {
	id("net.fabricmc.fabric-loom") version "1.15-SNAPSHOT"
}

val modVersion: String by extra
val minecraftVersion: String by extra
val loaderVersion: String by extra
val fabricApiVersion: String by extra

version = modVersion
group = "net.ethenehosting"

repositories {
	maven("https://repo.papermc.io/repository/maven-public/")
}

loom {
	accessWidenerPath = file("src/main/resources/paper_bridge.classtweaker")
}

dependencies {
	minecraft("com.mojang:minecraft:$minecraftVersion")
	implementation("net.fabricmc:fabric-loader:$loaderVersion")
	implementation("net.fabricmc.fabric-api:fabric-api:$fabricApiVersion")
	compileOnly("io.papermc.paper:paper-api:26.1.1.build.+")
}

tasks.processResources {
	inputs.property("version", modVersion)

	filesMatching("fabric.mod.json") {
		expand("version" to modVersion)
	}
}

tasks.withType<JavaCompile> {
	options.release = 25
}

java {
	withSourcesJar()

	sourceCompatibility = JavaVersion.VERSION_25
	targetCompatibility = JavaVersion.VERSION_25

	sourceSets {
		create("paper") {
			java {
				srcDir("src/paper/java")
			}
			resources {
				srcDir("src/paper/resources")
			}
		}
	}
}

tasks.jar {
	inputs.property("projectName", project.name)

	from("LICENSE") {
		rename { "${it}_${project.name}" }
	}
}
