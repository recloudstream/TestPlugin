# TestPlugin

`./gradlew make` to compile the plugin


repo.json is defined as:

*(? means optional parameter)*
```js
Repository {
    name: String,
    description: String?,
    manifestVersion: Int,
    pluginLists: List<String>
}
```

while plugins.json follows this json format: 
```js
SitePlugin {
    url: String,
    tvTypes: List<String>?,
    version: Int,
    apiVersion: Int,
    name: String,
    authors: List<String>,
    description: String?,
    repositoryUrl: String?,
    language: String?,
    iconUrl: String?
}
```

Click this link from the app to automatically install the repository:
[Repo download](https://cs.repo?raw.githubusercontent.com/recloudstream/TestPlugin/master/repo.json)
