
// Project: Vending Machine in Groovy
// Author: Michael Easter
//
// http://codetojoy.blogspot.com

package net.codetojoy.vending

def dslDef = new File("src/groovy/net/codetojoy/vending/dsl/VendingDSL.groovy").text

def dsl = new File("${args[0]}").text.toLowerCase()

def dslScript = 
"""
${dslDef}
machine.accept { ${dsl} }        
"""

new GroovyShell().evaluate(dslScript)

