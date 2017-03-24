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
package eu.fp7.eagle.portal.ui.dashboard;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Locale;

import eu.fp7.eagle.service.exception.EagleServiceException;

import eu.fp7.eagle.portal.ui.WebApp;
import eu.fp7.eagle.portal.ui.dashboard.i18n.DashboardMessages;
import eu.fp7.eagle.portal.ui.dashboard.service.DashboardService;
import eu.fp7.eagle.portal.ui.dashboard.view.DashboardViewProvider;
import eu.fp7.eagle.portal.ui.dashboard.view.badges.BadgesViewImpl;
import eu.fp7.eagle.portal.ui.dashboard.view.badges.BadgesViewPresenter;
import eu.fp7.eagle.portal.ui.util.UIUtil.WebAppMode;
import eu.fp7.eagle.portal.ui.view.ViewHandler;

/**
 * @author Arun Prakash [arun.prakash@fokus.fraunhofer.de]
 *
 * @since 07-Sep-2016 (1.0.0)
 * @version 1.0.0
 */

public class Dashboard extends WebApp<DashboardMessages, DashboardService, DashboardViewProvider<? extends ViewHandler>> {

	/**
	 * @param service
	 */
	public Dashboard(final DashboardService service) {
		super(new DashboardMessages(), checkNotNull(service, "Service must not be null"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.fp7.eagle.portal.ui.WebApp#init(java.util.Locale,
	 * eu.fp7.eagle.portal.ui.util.UIUtil.WebAppMode)
	 */
	@Override
	protected void init(final Locale locale, final WebAppMode appMode) {
		super.init(locale, appMode, true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.fp7.eagle.portal.ui.WebApp#initWebAppMainView()
	 */
	@Override
	protected DashboardViewProvider<? extends ViewHandler> initWebAppMainView() throws EagleServiceException {
		return super.initWebAppView(new BadgesViewImpl(), new BadgesViewPresenter());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.fp7.eagle.portal.ui.WebApp#initWebAppPreferencesView()
	 */
	@Override
	protected DashboardViewProvider<? extends ViewHandler> initWebAppPreferencesView() throws EagleServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.fp7.eagle.portal.ui.WebApp#initWebAppHelpView()
	 */
	@Override
	protected DashboardViewProvider<? extends ViewHandler> initWebAppHelpView() throws EagleServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
