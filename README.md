Building
--------

Zip up the plugin contents.

Installation
------------

Put the `rundeck-groovy-mock-plugin.zip` into your `$RDECK_BASE/libext` dir.

Usage
-----

You can configure the Resource Model Sources for a project either via the
RunDeck GUI, under the "Admin" page, or you can modify the `project.properties`
file to configure the sources.

See: [Resource Model Source Configuration](http://rundeck.org/1.4/RunDeck-Guide.html#resource-model-source-configuration)

The provider name is: `groovy-mock-plugin`

Here are the configuration properties:

* `url`: The URL to a fictitious remote node authority service (used to generate the editUrl attribute).
* `nodetype`: The type name for nodes you want to return.


