#!/usr/bin/env groovy

import groovy.xml.MarkupBuilder

//
// Lookup the plugin config settings exported as env vars
//

def env = System.getenv()
def url =  env['RD_CONFIG_URL']      // URL to remote server
def type = env['RD_CONFIG_NODETYPE'] // Type name to filter 

//
// Generate the XML as 'resourcexml' format
// Reference: http://rundeck.org/docs/manpages/man5/resource-v13.html
//
def writer = new StringWriter()
def xml = new MarkupBuilder(writer)
xml.project() {
    node(name:'mock-example', hostname: 'mock-example', 
	description:'a mocked example', tags:'mock', username:'appuser') {
	attribute(name: 'nodetype', value: "${type}")
	attribute(name: 'osArch', value: 'x86_64')
	attribute(name: 'osFamily', value: 'unix')
	attribute(name: 'osName', value: 'sunos')
	attribute(name: 'osVersion', value: '3.0')
	attribute(name: 'foo', value: 'fooValue')
	attribute(name: 'bar', value: 'barValue')
	attribute(name: 'id', value: '1')
	attribute(name: 'editUrl', value: "${url}/node/show/\${node.id}")
    }
}
//
// write the xml to standard out
//
println writer.toString()
