# TestPlugin

`./gradlew make` to compile the plugin


repo.json is defined as:

*(? means optional parameter)*
```kotlin
data class Repository(
    @JsonProperty("name") val name: String,
    @JsonProperty("description") val description: String?,
    @JsonProperty("manifestVersion") val manifestVersion: Int,
    @JsonProperty("pluginLists") val pluginLists: List<String>
)
```

while plugins.json follows this json format: 
```kotlin
/**
 * Status int as the following:
 * 0: Down
 * 1: Ok
 * 2: Slow
 * 3: Beta only
 * */
data class SitePlugin(
    // Url to the .cs3 file
    @JsonProperty("url") val url: String,
    // Status to remotely disable the provider
    @JsonProperty("status") val status: Int,
    // Integer over 0, any change of this will trigger an auto update
    @JsonProperty("version") val version: Int,
    // Unused currently, used to make the api backwards compatible?
    // Set to 1
    @JsonProperty("apiVersion") val apiVersion: Int,
    // Name to be shown in app
    @JsonProperty("name") val name: String,
    // Name to be referenced internally. Separate to make name and url changes possible
    @JsonProperty("internalName") val internalName: String,
    @JsonProperty("authors") val authors: List<String>,
    @JsonProperty("description") val description: String?,
    // Might be used to go directly to the plugin repo in the future
    @JsonProperty("repositoryUrl") val repositoryUrl: String?,
    // These types are yet to be mapped and used, ignore for now
    @JsonProperty("tvTypes") val tvTypes: List<String>?,
    @JsonProperty("language") val language: String?,
    @JsonProperty("iconUrl") val iconUrl: String?,
    // Set to true to get an 18+ symbol next to the plugin
    @JsonProperty("isAdult") val isAdult: Boolean?,
)
```

Click this link from the app to automatically install the repository:
[Repo download](https://cs.repo?raw.githubusercontent.com/recloudstream/TestPlugin/master/repo.json)
