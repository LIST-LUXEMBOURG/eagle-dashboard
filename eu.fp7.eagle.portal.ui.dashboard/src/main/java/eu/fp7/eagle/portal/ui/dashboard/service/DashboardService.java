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

import java.util.List;

import eu.fp7.eagle.service.exception.EagleServiceException;
import eu.fp7.eagle.service.model.NamedIdentifier;
import eu.fp7.eagle.service.model.UserBadgeType;

import eu.fp7.eagle.portal.ui.view.ViewService;

/**
 * @author Arun Prakash [arun.prakash@fokus.fraunhofer.de]
 *
 * @since 07-Sep-2016 (1.0.0)
 * @version 1.0.0
 */
public interface DashboardService extends ViewService {

	/**
	 * @param userBadgeType
	 * @return
	 * @throws EagleServiceException
	 */
	List<NamedIdentifier> getBadgeAchievements(UserBadgeType userBadgeType) throws EagleServiceException;

	/**
	 * @param nextBadge
	 * @return
	 * @throws EagleServiceException
	 */
	List<NamedIdentifier> getBadgeTasks(UserBadgeType nextBadge) throws EagleServiceException;

	/**
	 * @param userUri
	 * @param badgeType
	 * @return
	 * @throws EagleServiceException
	 */
	List<NamedIdentifier> getUserBadgeTasks(String userUri, UserBadgeType badgeType) throws EagleServiceException;

	/**
	 * @param userUri
	 * @return
	 * @throws EagleServiceException
	 */
	List<UserBadgeType> getUserBadges(String userUri) throws EagleServiceException;

}
