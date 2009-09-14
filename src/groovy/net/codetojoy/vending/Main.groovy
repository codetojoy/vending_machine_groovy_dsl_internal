
// Project: Vending Machine in Groovy
// Author: Michael Easter
//
// http://codetojoy.blogspot.com

package net.codetojoy.vending

def dslDef = new File("${args[0]}").text

def input = new File("${args[1]}").text.toLowerCase()

// dslDef creates the object 'machine', which accepts the DSL input:
def dslScript = " $dslDef ; machine.accept { $input } "

new GroovyShell().evaluate(dslScript)

