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
package eu.fp7.eagle.portal.ui.dashboard.service;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;

import java.util.List;

import eu.fp7.eagle.service.exception.EagleServiceException;
import eu.fp7.eagle.service.model.NamedIdentifier;
import eu.fp7.eagle.service.model.UserBadgeType;

import eu.fp7.eagle.portal.ui.services.AbstractViewService;

/**
 * @author Arun Prakash [arun.prakash@fokus.fraunhofer.de]
 *
 * @since 07-Sep-2016 (1.0.0)
 * @version 1.0.0
 */
public class DashboardServiceImpl extends AbstractViewService implements DashboardService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.fp7.eagle.portal.ui.dashboard.service.DashboardService#
	 * getBadgeAchievements(eu.fp7.eagle.service.model.UserBadgeType)
	 */
	@Override
	public List<NamedIdentifier> getBadgeAchievements(final UserBadgeType userBadgeType) throws EagleServiceException {
		// preconditions
		checkNotNull(userBadgeType, "UserBadgeType must not be null");

		return this.getServiceProvider().getBadgeAchievements(userBadgeType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.fp7.eagle.portal.ui.dashboard.service.DashboardService#getBadgeTasks
	 * (eu.fp7.eagle.service.model.UserBadgeType)
	 */
	@Override
	public List<NamedIdentifier> getBadgeTasks(final UserBadgeType userBadgeType) throws EagleServiceException {
		// preconditions
		checkNotNull(userBadgeType, "UserBadgeType must not be null");

		return this.getServiceProvider().getBadgeTasks(userBadgeType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.fp7.eagle.portal.ui.dashboard.service.DashboardService#getUserBadges
	 * (java.lang.String)
	 */
	@Override
	public List<UserBadgeType> getUserBadges(final String userUri) throws EagleServiceException {
		// preconditions
		checkArgument(!isNullOrEmpty(userUri), "User URI must not be null or empty");

		return this.getServiceProvider().getUserBadges(userUri);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.fp7.eagle.portal.ui.dashboard.service.DashboardService#getUserBadgeTasks
	 * (java.lang.String, eu.fp7.eagle.service.model.UserBadgeType)
	 */
	@Override
	public List<NamedIdentifier> getUserBadgeTasks(final String userUri, final UserBadgeType userBadgeType) throws EagleServiceException {
		// preconditions
		checkArgument(!isNullOrEmpty(userUri), "User URI must not be null or empty");
		checkNotNull(userBadgeType, "UserBadgeType must not be null");

		return this.getServiceProvider().getUserBadgeTasks(userUri, userBadgeType);
	}

}
