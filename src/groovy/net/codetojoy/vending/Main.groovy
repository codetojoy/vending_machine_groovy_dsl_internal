
// Project: Vending Machine in Groovy
// Author: Michael Easter
//
// http://codetojoy.blogspot.com

package net.codetojoy.vending

def dslDef = new File("src/groovy/net/codetojoy/vending/dsl/VendingDSL.groovy").text

def text = new File("${args[0]}").text.toLowerCase()
// cheating!
def dsl = text.replace("\$", "r")

def dslScript = 
"""
${dslDef}
machine.accept { ${dsl} }        
"""

new GroovyShell().evaluate(dslScript)

