/*
AbstractFunction.java
 *    
 *    Copyright (c) 2003-2005, Benja Fallenstein
 *    
 *    This file is part of Fenfire.
 *    
 *    Fenfire is free software; you can redistribute it and/or modify it under
 *    the terms of the GNU Lesser General Public License as published by
 *    the Free Software Foundation; either version 2 of the License, or
 *    (at your option) any later version.
 *    
 *    Fenfire is distributed in the hope that it will be useful, but WITHOUT
 *    ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 *    or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General
 *    Public License for more details.
 *    
 *    You should have received a copy of the GNU Lesser General
 *    Public License along with Fenfire; if not, write to the Free
 *    Software Foundation, Inc., 59 Temple Place, Suite 330, Boston,
 *    MA  02111-1307  USA
 *    
 *    
 */
/*
 * Written by Benja Fallenstein
 */

package org.fenfire.potion;
import java.util.*;

public abstract class AbstractFunction extends AbstractHead 
    implements Function {


    public AbstractFunction(Object[] spec) { super(spec); }


    public FunctionExpression call() {
	return new FunctionExpression(this, new FunctionExpression[] {});
    }
    public FunctionExpression call(FunctionExpression p1) {
	return new FunctionExpression(this, new FunctionExpression[] {p1});
    }
    public FunctionExpression call(FunctionExpression p1, 
				   FunctionExpression p2) {
	return new FunctionExpression(this, new FunctionExpression[] {p1,p2});
    }
    public FunctionExpression call(FunctionExpression p1, 
				   FunctionExpression p2, 
				   FunctionExpression p3) {
	return new FunctionExpression(this, new FunctionExpression[] {p1,p2,p3});
    }


    public static abstract class Pattern extends AbstractFunction {
	public Pattern() { super(new Object[] {}); }	

	public String getString() { 
	    throw new Error("pattern not instantiated"); 
	}
	public Type[] getParams() {
	    throw new Error("pattern not instantiated"); 
	}
	public List evaluate(List[] params, Map context) {
	    throw new Error("pattern not instantiated"); 
	}
    }
    
}
