# native-metadata-demo

Semplice progetto dimostrativo sui metadata per la compilazione nativa.

Vedi [native-helper-maven-plugin](https://github.com/fugerit-org/native-helper-maven-plugin) per maggiori informazioni.

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
                <goal>nativeHelper</goal>
            </goals>
        </execution>
    </executions>
    <configuration>
        <!-- file di configurazione per la generazione dei metadati -->
        <nativeHelperConfigPath>src/main/config/native-helper-config.yaml</nativeHelperConfigPath>
        <!-- aggiungiamo direttamente i metadati alla directory di output del progetto -->
        <reflectConfigJsonOutputPath>${project.build.outputDirectory}/META-INF/native-image/reflect-config.json</reflectConfigJsonOutputPath>
        <warnOnError>true</warnOnError>
    </configuration>
</plugin>
```