/*
SpatialViewSettings.java
 *    
 *    Copyright (c) 2004-2005, Benja Fallenstein and Matti Katila
 *
 *    This file is part of Libvob.
 *    
 *    Libvob is free software; you can redistribute it and/or modify it under
 *    the terms of the GNU General Public License as published by
 *    the Free Software Foundation; either version 2 of the License, or
 *    (at your option) any later version.
 *    
 *    Libvob is distributed in the hope that it will be useful, but WITHOUT
 *    ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 *    or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General
 *    Public License for more details.
 *    
 *    You should have received a copy of the GNU General
 *    Public License along with Libvob; if not, write to the Free
 *    Software Foundation, Inc., 59 Temple Place, Suite 330, Boston,
 *    MA  02111-1307  USA
 *    
 *
 */
/*
 * Written by Benja Fallenstein and Matti Katila
 */
package org.fenfire.view;
import org.fenfire.Cursor;
import org.nongnu.libvob.layout.*;
import org.nongnu.libvob.*;
import org.nongnu.libvob.util.*;
import org.nongnu.navidoc.util.Obs;
import java.util.*;

public class SpatialViewSettings extends ViewSettings {

    public interface SpatialView extends View {
	boolean showBig(); // whether the mainview should be shown big
	Lob getMainviewLob(Cursor cursor);
	Lob getBuoyLob(Object node);
    }

    public SpatialViewSettings(Set views) {
	super(views);
    }

    protected Replaceable[] getParams() {
	return new Replaceable[] { };
    }
    protected Object clone(Object[] params) {
	return new SpatialViewSettings(views);
    }

    private Lob errorLob = new org.nongnu.libvob.layout.component.Label("No matching spatial view found!");

    public Lob getMainviewLob(Cursor cursor) {
	SpatialView v = (SpatialView)getViewByCursor(cursor);
	if(v != null)
	    return v.getMainviewLob(cursor);
	else
	    return errorLob;
    }

    public Lob getBuoyLob(Object node) {
	SpatialView v = (SpatialView)getViewByNode(node);
	if(v != null)
	    return v.getBuoyLob(node);
	else
	    return errorLob;
    }

    public boolean showBig(Cursor cursor) {
	SpatialView v = (SpatialView)getViewByCursor(cursor);
	if(v != null)
	    return v.showBig();
	else
	    return false;
    }
}