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
package eu.fp7.eagle.portal.ui.dashboard.view;

import eu.fp7.eagle.portal.ui.dashboard.i18n.DashboardMessages;
import eu.fp7.eagle.portal.ui.view.AbstractViewProvider;
import eu.fp7.eagle.portal.ui.view.ViewHandler;

/**
 * @author Arun Prakash [arun.prakash@fokus.fraunhofer.de]
 *
 * @since 07-Sep-2016 (1.0.0)
 * @version 1.0.0
 */
public abstract class DashboardViewProvider<H extends ViewHandler> extends AbstractViewProvider<H, DashboardMessages> {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -1819501263281561863L;

}
