/**
 * Copyright (c) 2016-2017  Luxembourg Institute of Science and Technology (LIST).
 * 
 * This software is licensed under the Apache License, Version 2.0 (the "License") ; you
 * may not use this file except in compliance with the License. You may obtain a copy of the License
 * at : http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 * 
 * for more information about the software, please contact info@list.lu
 */
package eu.fp7.eagle.portal.ui.portlet.dashboard;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;

import eu.fp7.eagle.portal.ui.dashboard.Dashboard;
import eu.fp7.eagle.portal.ui.dashboard.service.DashboardServiceImpl;

import eu.fp7.eagle.portal.ui.WebAppUI;

@Theme("eagle")
@Widgetset("eu.fp7.eagle.portal.ui.portlet.dashboard.AppWidgetSet")
public class EagleDashboardUI extends WebAppUI {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -5651254484109694042L;

	/**
	 * @param webApp
	 */
	public EagleDashboardUI() {
		super(new Dashboard(new DashboardServiceImpl()));
	}

}
