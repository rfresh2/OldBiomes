# OldBiomes
Standalone Biome Generator for [XaeroPlus](https://github.com/rfresh2/XaeroPlus) OldBiomes feature

This is a fork of [KaptainWutax's BiomeUtils library](https://github.com/KaptainWutax/BiomeUtils) and its associated dependencies

The only changes I've made are removing unneeded classes to reduce jar size. And adding publishing to my personal maven: `https://maven.2b2t.vc`

# Usage

Gradle:

```
repositories {
    maven("https://maven.2b2t.vc/releases")
}

dependencies {
    implementation("com.github.rfresh2:OldBiomes:1.0")
}
```

Maven:

```
<repositories>
    <repository>
        <id>2b2t.vc</id>
        <url>https://maven.2b2t.vc/releases</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.rfresh2</groupId>
        <artifactId>OldBiomes</artifactId>
        <version>1.0</version>
    </dependency>
<dependencies>
```
