plugins {
	id("net.fabricmc.fabric-loom") version "1.15-SNAPSHOT"
}

val modVersion: String by extra
val minecraftVersion: String by extra
val loaderVersion: String by extra
val fabricApiVersion: String by extra

version = modVersion
group = "dev.tonimatas"

repositories {
	maven("https://repo.papermc.io/repository/maven-public/")
	maven("https://nexus.c0d3m4513r.com/repository/Ketting/")
}

dependencies {
	minecraft("com.mojang:minecraft:$minecraftVersion")
	implementation("net.fabricmc:fabric-loader:$loaderVersion")
	implementation("net.fabricmc.fabric-api:fabric-api:$fabricApiVersion")
	implementation("io.papermc.paper:paper-api:26.1.1.build.+")
	implementation("org.kettingpowered:MixinExtras:[0.0.1, 0.1.0)")
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
}

tasks.jar {
	inputs.property("projectName", project.name)

	from("LICENSE") {
		rename { "${it}_${project.name}" }
	}
}
