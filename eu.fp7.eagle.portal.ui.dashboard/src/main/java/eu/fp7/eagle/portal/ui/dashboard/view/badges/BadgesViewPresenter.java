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
package eu.fp7.eagle.portal.ui.dashboard.view.badges;

import java.util.ArrayList;
import java.util.List;

import eu.fp7.eagle.service.exception.EagleServiceException;
import eu.fp7.eagle.service.model.NamedIdentifier;
import eu.fp7.eagle.service.model.UserBadgeType;

public class BadgesViewPresenter extends BadgesViewHandler {

	@Override
	public List<NamedIdentifier> performBadgeAchievements(final String prefix) {
		List<NamedIdentifier> resultinter = new ArrayList<NamedIdentifier>();
		final List<NamedIdentifier> result = new ArrayList<NamedIdentifier>();

		try {
			final List<UserBadgeType> listBadgesUser = this.getListBadgesUser();
			final List<UserBadgeType> listBadgesUserForPrefix = this.getListBadgesUserForPrefix(listBadgesUser, prefix);
			final List<UserBadgeType> listOrderedBadgesUser = this.orderListBadges(listBadgesUserForPrefix, this.getListBadges(prefix));
			for (int i = 0; i < listOrderedBadgesUser.size(); i++) {
				// resultinter =
				// this.getService().getServiceProvider().getKnowledgeService().getBadgeAchievements(listOrderedBadgesUser.get(i));
				resultinter = this.getService().getBadgeAchievements(listOrderedBadgesUser.get(i));
				result.addAll(resultinter);
			}
		} catch (final EagleServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			super.getView().notifyError(e.getErrorCode());
		}
		return result;
	}

	@Override
	public List<NamedIdentifier> performNextBadgeTasks(final UserBadgeType userBadgeType, final String prefix) {
		List<NamedIdentifier> result = new ArrayList<NamedIdentifier>();

		try {
			final UserBadgeType nextBadge = this.getNextBadge(userBadgeType, prefix);
			// result =
			// this.getService().getServiceProvider().getKnowledgeService().getBadgeTasks(nextBadge);
			result = this.getService().getBadgeTasks(nextBadge);

		} catch (final EagleServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			super.getView().notifyError(e.getErrorCode());
		}

		return result;
	}

	@Override
	public List<NamedIdentifier> performUserTasks(final String prefix) {
		String userUri = null;
		List<NamedIdentifier> result = new ArrayList<NamedIdentifier>();
		final int count = 0;
		try {
			userUri = this.getService().getUser().getUri();
		} catch (final EagleServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			super.getView().notifyError(e.getErrorCode());
		}
		if (userUri != null) {
			try {
				final UserBadgeType badgeType = this.getNextBadge(this.getBestBadge(prefix), prefix);
				// result =
				// this.getService().getServiceProvider().getKnowledgeService().getUserTasks(userUri,
				// badgeType);
				result = this.getService().getUserBadgeTasks(userUri, badgeType);

			} catch (final EagleServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				super.getView().notifyError(e.getErrorCode());
			}
		}

		return result;
	}

	public List<UserBadgeType> getListBadgesUser() {
		String userUri = null;
		List<UserBadgeType> listBadges = new ArrayList<UserBadgeType>();
		try {
			userUri = this.getService().getUser().getUri();
		} catch (final EagleServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			super.getView().notifyError(e.getErrorCode());
		}
		if (userUri != null) {
			try {
				// listBadges =
				// this.getService().getServiceProvider().getKnowledgeService().getAwardedBadges(userUri);
				listBadges = this.getService().getUserBadges(userUri);
			} catch (final EagleServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				super.getView().notifyError(e.getErrorCode());
			}
		}

		return listBadges;
	}

	@Override
	public UserBadgeType getBestBadge(final String prefix) {
		final List<UserBadgeType> listBadges = this.getListBadgesUser();
		int count = 0;
		for (int i = 0; i < listBadges.size(); i++) {
			if (listBadges.get(i).toString().startsWith(prefix)) {
				count++;
			}
		}
		if (prefix.equals("OER_CREATOR")) {

			if (count == 1) {
				return (UserBadgeType.OER_CREATOR_NOVICE);
			} else if (count == 2) {
				return (UserBadgeType.OER_CREATOR_INTERMEDIATE);
			} else if (count == 3) {
				return (UserBadgeType.OER_CREATOR_ADVANCED);
			} else if (count == 4) {
				return (UserBadgeType.OER_CREATOR_EXPERT);
			}

		} else if (prefix.equals("REVIEWER")) {

			if (count == 1) {
				return (UserBadgeType.REVIEWER_NOVICE);
			} else if (count == 2) {
				return (UserBadgeType.REVIEWER_INTERMEDIATE);
			} else if (count == 3) {
				return (UserBadgeType.REVIEWER_ADVANCED);
			} else if (count == 4) {
				return (UserBadgeType.REVIEWER_EXPERT);
			}
		} else if (prefix.equals("NETWORKER")) {

			if (count == 1) {
				return (UserBadgeType.NETWORKER_NOVICE);
			} else if (count == 2) {
				return (UserBadgeType.NETWORKER_INTERMEDIATE);
			} else if (count == 3) {
				return (UserBadgeType.NETWORKER_ADVANCED);
			} else if (count == 4) {
				return (UserBadgeType.NETWORKER_EXPERT);
			}
		}

		return null;
	}

	private List<UserBadgeType> getListBadgesUserForPrefix(final List<UserBadgeType> listBadgeUser, final String prefix) {
		final List<UserBadgeType> result = new ArrayList<UserBadgeType>();
		for (int i = 0; i < listBadgeUser.size(); i++) {
			if (listBadgeUser.get(i).toString().startsWith(prefix)) {
				result.add(listBadgeUser.get(i));
			}
		}
		return result;
	}

	private List<UserBadgeType> getListBadges(final String prefix) {

		if (prefix.equals("OER_CREATOR")) {
			final List<UserBadgeType> oerCreatorBadgeTypeList = new ArrayList<UserBadgeType>();
			oerCreatorBadgeTypeList.add(UserBadgeType.OER_CREATOR_NOVICE);
			oerCreatorBadgeTypeList.add(UserBadgeType.OER_CREATOR_INTERMEDIATE);
			oerCreatorBadgeTypeList.add(UserBadgeType.OER_CREATOR_ADVANCED);
			oerCreatorBadgeTypeList.add(UserBadgeType.OER_CREATOR_EXPERT);
			return oerCreatorBadgeTypeList;
		} else if (prefix.equals("REVIEWER")) {
			final List<UserBadgeType> reviewerBadgeTypeList = new ArrayList<UserBadgeType>();
			reviewerBadgeTypeList.add(UserBadgeType.REVIEWER_NOVICE);
			reviewerBadgeTypeList.add(UserBadgeType.REVIEWER_INTERMEDIATE);
			reviewerBadgeTypeList.add(UserBadgeType.REVIEWER_ADVANCED);
			reviewerBadgeTypeList.add(UserBadgeType.REVIEWER_EXPERT);
			return reviewerBadgeTypeList;
		} else if (prefix.equals("NETWORKER")) {
			final List<UserBadgeType> networkerBadgeTypeList = new ArrayList<UserBadgeType>();
			networkerBadgeTypeList.add(UserBadgeType.NETWORKER_NOVICE);
			networkerBadgeTypeList.add(UserBadgeType.NETWORKER_INTERMEDIATE);
			networkerBadgeTypeList.add(UserBadgeType.NETWORKER_ADVANCED);
			networkerBadgeTypeList.add(UserBadgeType.NETWORKER_EXPERT);
			return networkerBadgeTypeList;
		}
		return null;

	}

	private List<UserBadgeType> orderListBadges(final List<UserBadgeType> notOrderedList, final List<UserBadgeType> listOrdered) {
		final List<UserBadgeType> result = new ArrayList<UserBadgeType>();
		for (int i = 0; i < notOrderedList.size(); i++) {
			final int a = listOrdered.indexOf(notOrderedList.get(i));
			boolean stop = false;
			for (int j = 0; j < result.size() && !stop; j++) {
				final int b = listOrdered.indexOf(result.get(j));
				if (a < b) {
					result.add(j, notOrderedList.get(i));
					stop = true;
				}
			}
			if (!stop) {
				result.add(notOrderedList.get(i));
			}

		}
		return result;
	}

	private UserBadgeType getNextBadge(final UserBadgeType badgeType, final String prefix) {
		UserBadgeType result = null;
		if (badgeType != null) {
			if (badgeType.toString().endsWith("EXPERT")) {
				result = badgeType;
			} else {
				final List<UserBadgeType> badgeTypeList = this.getListBadges(prefix);
				final int next = badgeTypeList.indexOf(badgeType) + 1;
				result = badgeTypeList.get(next);
			}
		} else {
			if (prefix.startsWith("OER_CREATOR")) {
				result = UserBadgeType.OER_CREATOR_NOVICE;
			} else if (prefix.startsWith("REVIEWER")) {
				result = UserBadgeType.REVIEWER_NOVICE;
			} else if (prefix.startsWith("NETWORKER")) {
				result = UserBadgeType.NETWORKER_NOVICE;
			}
		}

		return result;

	}

}
