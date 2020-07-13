# MetricsModule

The Slimefun metrics module is an independent small piece of software meant to decouple bStats from Slimefun and allow us to deploy new metric tracking (and in turn have much better metric testing ability) within the space of an hour to all servers.

This works by Slimefun itself looking for updates to this module, downloading the jar, loading the classes into the Spigot server JVM (as a child class loader to the SF PluginClassLoader) and then starting it. This will allow us to push new metric versions (Which means we can add things like new charts) without having to release a new Slimefun build and wait for people to update (or for auto-updates to trigger on restart).
This means that most servers can be pushing metrics for us within the space of an hour. This is much quicker than the usual few days or even month, especially since we also have RC (Release Candidate) builds which are not pushed too often but constitute about ~25% of our users.
