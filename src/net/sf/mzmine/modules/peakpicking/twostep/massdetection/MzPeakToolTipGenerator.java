/*
 * Copyright 2006-2008 The MZmine Development Team
 * 
 * This file is part of MZmine.
 * 
 * MZmine is free software; you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * MZmine is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * MZmine; if not, write to the Free Software Foundation, Inc., 51 Franklin St,
 * Fifth Floor, Boston, MA 02110-1301 USA
 */

package net.sf.mzmine.modules.peakpicking.twostep.massdetection;

import java.text.NumberFormat;

import net.sf.mzmine.main.MZmineCore;

import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.data.xy.XYDataset;

/**
 * Tooltip generator for picked MzPeaks
 */
class MzPeakToolTipGenerator implements XYToolTipGenerator {

	private NumberFormat mzFormat = MZmineCore.getMZFormat();
	private NumberFormat intensityFormat = MZmineCore.getIntensityFormat();

	/**
	 * @see org.jfree.chart.labels.XYToolTipGenerator#generateToolTip(org.jfree.data.xy.XYDataset,
	 *      int, int)
	 */
	public String generateToolTip(XYDataset dataset, int series, int item) {

		double intValue = dataset.getYValue(series, item);
		double mzValue = dataset.getXValue(series, item);

		String tooltip = "<html>" + "m/z peak is detected at <br>m/z: "
				+ mzFormat.format(mzValue) + "<br>intensity: "
				+ intensityFormat.format(intValue) + "</html>";

		return tooltip;

	}

}
