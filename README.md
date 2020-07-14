# Slimefun - Metrics Module
The Slimefun metrics module is an independent small piece of software meant to decouple our [bStats](https://bstats.org/plugin/bukkit/Slimefun/4574) integration from Slimefun.
It also allows us to create new charts and metrics without the need of everyone using the latest DEV - builds of Slimefun.

## Metrics collection
All collected data is publicly accessible: https://bstats.org/plugin/bukkit/Slimefun/4574<br>
We do not collect any personal data from you, any data is collected anonymously and you are able to disable this data collection at any time in your `plugins/bStats/config.yml` file. For more info see [bStats's Privacy Policy](https://bstats.org/privacy-policy).
You can also disable automic updates in Slimefun's `config.yml`, although we do recommend you to keep automatic updates enabled, in order to not miss out on any important patches or fixes to Slimefun.

The entire premise behind these metrics is for us to improve Slimefun as a whole, monitoring performance spikes and drops for examples or just generally seeing what Server Software, language, Minecraft version, Slimefun version or Slimefun addons people use, as well as much more.
These insights can help us improve and optimize Slimefun and get a better understanding of how this Plugin is used.

You can view all charts on bStats: https://bstats.org/plugin/bukkit/Slimefun/4574

## Technical Details
This works by Slimefun itself looking for updates to this module when the Server boots up.
If an update is found, it will download the newest Metrics module (just like it downloads a new Slimefun update) and loads the classes into the Spigot server JVM (as a child class loader to Slimefun's `PluginClassLoader`).
This will allow us to push new metric versions (Which means we can add things like new charts) without having to release a new Slimefun build and wait for everyone to use the latest DEV - build.
This is especially useful since we also have RC (Release Candidate) builds which are not pushed too often but constitute about ~25% of our users.
