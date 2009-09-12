
// Project: Vending Machine in Groovy
// Author: Michael Easter
//
// http://codetojoy.blogspot.com

package net.codetojoy.vending

def dslDef = new File("src/groovy/net/codetojoy/vending/dsl/VendingDSL.groovy").text

def text = new File("${args[0]}").text.toLowerCase()
// cheat 1
def tmp1 = text.replace("\$", "r")
// cheat 2
def dsl = tmp1.replace("coin_return", "coinreturn")

def dslScript = 
"""
${dslDef}
machine.accept { ${dsl} }        
"""

new GroovyShell().evaluate(dslScript)

