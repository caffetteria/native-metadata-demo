# native-metadata-demo

Semplice progetto dimostrativo sui metadata per la compilazione nativa.

Vedi [native-helper-maven-plugin](https://github.com/fugerit-org/native-helper-maven-plugin) per maggiori informazioni.

[![CI maven build and scan](https://github.com/caffetteria/native-metadata-demo/actions/workflows/build_maven_package.yml/badge.svg)](https://github.com/caffetteria/native-metadata-demo/actions/workflows/build_maven_package.yml)

## Quickstart

Aggiung il plugin al tuo file *pom.xml* :

```xml
<plugin>
    <groupId>org.fugerit.java</groupId>
    <artifactId>native-helper-maven-plugin</artifactId>
    <version>${native-helper-maven-plugin-version}</version>
    <executions>
        <execution>
            <id>generate-native-configuration</id>
            <phase>prepare-package</phase>
            <goals>
                <goal>generate</goal>
            </goals>
            <configuration>
                <!-- file di configurazione per la generazione dei metadati -->
                <nativeHelperConfigPath>src/main/config/native-helper-config.yaml</nativeHelperConfigPath>
                <!-- aggiungiamo direttamente i metadati alla directory di output del progetto -->
                <reflectConfigJsonOutputPath>${project.build.directory}/generated-resources/reflect-config-demo.json</reflectConfigJsonOutputPath>
                <!-- se deve essere creata la cartella padre di reflectConfigJsonOutputPath -->
                <createParentDirectory>true</createParentDirectory>
                <!-- gli errori vengono loggati invece di far fallire la build -->
                <warnOnError>true</warnOnError>
            </configuration>
        </execution>
        <execution>
            <id>merge-native-configuration</id>
            <phase>prepare-package</phase>
            <goals>
                <goal>merge</goal>
            </goals>
            <configuration>
                <!-- list dei file nel formato reflect-config.json da unire insieme -->
                <reflectConfigJsonFiles>
                    <reflectConfigJsonFile>${project.build.directory}/generated-resources/reflect-config-demo.json</reflectConfigJsonFile>
                    <reflectConfigJsonFile>${project.basedir}/src/main/config/reflect-config-nhg.json</reflectConfigJsonFile>
                </reflectConfigJsonFiles>
                <!-- il file di output con l'unione degli altri file reflect-config.json -->
                <reflectConfigJsonOutputPath>${project.build.outputDirectory}/META-INF/native-image/reflect-config.json</reflectConfigJsonOutputPath>
                <!-- se deve essere creata la cartella padre di reflectConfigJsonOutputPath -->
                <createParentDirectory>true</createParentDirectory>
                <!-- gli errori vengono loggati invece di far fallire la build -->
                <warnOnError>true</warnOnError>
            </configuration>
        </execution>
    </executions>
</plugin>
```