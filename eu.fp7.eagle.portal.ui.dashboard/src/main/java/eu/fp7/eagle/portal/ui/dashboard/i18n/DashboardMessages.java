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
package eu.fp7.eagle.portal.ui.dashboard.i18n;

import java.util.Locale;

import eu.fp7.eagle.portal.ui.i18n.Messages;
import eu.fp7.eagle.portal.ui.i18n.MessagesException;

/**
 * @author Arun Prakash [arun.prakash@fokus.fraunhofer.de]
 *
 * @since 07-Sep-2016 (1.0.0)
 * @version 1.0.0
 */
public class DashboardMessages extends Messages {

	private static final String	BUNDLE_NAME	= "eu.fp7.eagle.portal.ui.dashboard.l10n.messages";	//$NON-NLS-1$

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.fp7.eagle.portal.ui.i18n.Messages#initializeMessages(java.util.Locale)
	 */
	@Override
	public void initializeMessages(final Locale locale) {
		try {
			super.initializeMessages(BUNDLE_NAME, locale);
		} catch (final MessagesException e) {
			e.printStackTrace();
		}
	}
}