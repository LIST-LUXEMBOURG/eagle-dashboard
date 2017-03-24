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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.shared.MouseEventDetails.MouseButton;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.Table;

import eu.fp7.eagle.portal.ui.dashboard.design.BadgesDesign;
import eu.fp7.eagle.portal.ui.dashboard.design.impl.BadgesDesignImpl;
import eu.fp7.eagle.service.model.NamedIdentifier;
import eu.fp7.eagle.service.model.UserBadgeType;


public class BadgesViewImpl extends BadgesView implements ClickListener, LayoutClickListener {


	private static final long	serialVersionUID	= -1378635466952225945L;

	private static final String LabelTasks="To reach the next level you have to do the following tasks in grey:";

	private static final String LabelAch ="Your achievements";


	private BadgesDesign		design;

	private Container achievementsContainerReviewer;

	private Container tasksContainerReviewer;

	private UserBadgeType badgeTypeReviewer;

	private Container achievementsContainerOERCreator;

	private Container tasksContainerOERCreator;

	private UserBadgeType badgeTypeOERCreator;

	private Container achievementsContainerNetworker;

	private Container tasksContainerNetworker;

	private UserBadgeType badgeTypeNetworker;

	private List<NamedIdentifier>  listTasksReviewer;

	private List<NamedIdentifier>  listTasksOERCreator;

	private List<NamedIdentifier>  listTasksNetworker;

	private List<NamedIdentifier>  listUserTasksReviewer;

	private List<NamedIdentifier>  listUserTasksOERCreator;

	private List<NamedIdentifier>  listUserTasksNetworker;






	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.fp7.eagle.portal.ui.view.ViewProvider#init()
	 */
	@Override
	public void init() {

		badgeTypeReviewer = this.handler.getBestBadge("REVIEWER");
		badgeTypeOERCreator = this.handler.getBestBadge("OER_CREATOR");
		badgeTypeNetworker = this.handler.getBestBadge("NETWORKER");
		listTasksReviewer = this.handler.performNextBadgeTasks(badgeTypeReviewer,"REVIEWER");
		listTasksOERCreator = this.handler.performNextBadgeTasks(badgeTypeOERCreator,"OER_CREATOR");
		listTasksNetworker = this.handler.performNextBadgeTasks(badgeTypeNetworker,"NETWORKER");
		listUserTasksReviewer = this.handler.performUserTasks("REVIEWER");
		listUserTasksOERCreator = this.handler.performUserTasks("OER_CREATOR");
		listUserTasksNetworker = this.handler.performUserTasks("NETWORKER");

		//For testing
		////// FIXME TODO to remove after tests
		//badgeTypeOERCreator = null;
		Map<String,Boolean> greyParams = initGreyParam();
		this.design = new BadgesDesignImpl(greyParams);

		this.registerListeners();
		this.performDatabinding();

		this.setCompositionRoot(design);

	}

	private Map<String, Boolean> initGreyParam(){
		Map<String,Boolean> result = new HashMap<String, Boolean>();
		if (badgeTypeReviewer == null) result.put("REVIEWER",true);
		else result.put("REVIEWER",false);
		if (badgeTypeOERCreator == null) result.put("OER_CREATOR",true);
		else result.put("OER_CREATOR",false);
		if (badgeTypeNetworker == null) result.put("NETWORKER",true);
		else result.put("NETWORKER",false);
		return result;
	}

	private void registerListeners() {
		this.design.getImageBadgeRev().addClickListener(this);
		this.design.getBarLayoutReviewer().addLayoutClickListener(this);

		this.design.getImageBadgeOC().addClickListener(this);
		this.design.getBarLayoutOERCreator().addLayoutClickListener(this);
		
		this.design.getImageBadgeNet().addClickListener(this);
		this.design.getBarLayoutNetworker().addLayoutClickListener(this);

	}

	private void performDatabinding(){
		achievementsContainerReviewer = new IndexedContainer();
		achievementsContainerReviewer.addContainerProperty(LabelAch, String.class, null);
		this.design.getTableAchReviewer().setContainerDataSource(achievementsContainerReviewer);
		tasksContainerReviewer = new IndexedContainer();
		tasksContainerReviewer.addContainerProperty(LabelTasks, String.class, null);
		this.design.getTableTasksReviewer().setContainerDataSource(tasksContainerReviewer);
		this.design.getProgressBarReviewer().setValue(initProgressBarValue(badgeTypeReviewer, "REVIEWER"));

		achievementsContainerOERCreator = new IndexedContainer();
		achievementsContainerOERCreator.addContainerProperty(LabelAch, String.class, null);
		this.design.getTableAchOERCreator().setContainerDataSource(achievementsContainerOERCreator);
		tasksContainerOERCreator = new IndexedContainer();
		tasksContainerOERCreator.addContainerProperty(LabelTasks, String.class, null);
		this.design.getTableTasksOERCreator().setContainerDataSource(tasksContainerOERCreator);
		this.design.getProgressBarOERCreator().setValue(initProgressBarValue(badgeTypeOERCreator,"OER_CREATOR"));

		achievementsContainerNetworker = new IndexedContainer();
		achievementsContainerNetworker.addContainerProperty(LabelAch, String.class, null);
		this.design.getTableAchNetworker().setContainerDataSource(achievementsContainerNetworker);
		tasksContainerNetworker = new IndexedContainer();
		tasksContainerNetworker.addContainerProperty(LabelTasks, String.class, null);
		this.design.getTableTasksNetworker().setContainerDataSource(tasksContainerNetworker);
		this.design.getProgressBarNetworker().setValue(initProgressBarValue(badgeTypeNetworker,"NETWORKER"));

	}


	@Override
	public void click(ClickEvent event) {
		String id = event.getComponent().getId();
		MouseButton mouseButton = event.getButton();
		if(mouseButton.equals(MouseButton.LEFT)){
		if (id.equals("REVIEWER")){
			fillPopupAch("REVIEWER", achievementsContainerReviewer);
			this.design.getPopupViewAchReviewer().setPopupVisible(true);
		}
		else if (id.equals("OER_CREATOR")){
			fillPopupAch("OER_CREATOR", achievementsContainerOERCreator);
			this.design.getPopupViewAchOERCreator().setPopupVisible(true);
		}
		else if (id.equals("NETWORKER")){
			fillPopupAch("NETWORKER", achievementsContainerNetworker);
			this.design.getPopupViewAchNetworker().setPopupVisible(true);
		}
		}



	}

	@Override
	public void layoutClick(LayoutClickEvent event) {
		String id = event.getComponent().getId();
		MouseButton mouseButton = event.getButton();
		if(mouseButton.equals(MouseButton.LEFT)){
		if (id.equals("BL_REVIEWER")){
			List<Object> listItemId = fillPopupTasks("REVIEWER", tasksContainerReviewer);
			this.updateDesignTableTasksReviewer(listItemId);
			this.design.getPopupViewTasksReviewer().setPopupVisible(true);
		}
		else if (id.equals("BL_OER_CREATOR")){
			List<Object> listItemId = fillPopupTasks("OER_CREATOR", tasksContainerOERCreator);
			this.updateDesignTableTasksOERCreator(listItemId);
			this.design.getPopupViewTasksOERCreator().setPopupVisible(true);
		}
		else if (id.equals("BL_NETWORKER")){
			List<Object> listItemId = fillPopupTasks("NETWORKER", tasksContainerNetworker);
			this.updateDesignTableTasksNetworker(listItemId);
			this.design.getPopupViewTasksNetworker().setPopupVisible(true);
		}
		}
	}

	private void fillPopupAch(String prefix, Container container){

		List<NamedIdentifier> listAchievements = ((BadgesViewHandler) this.handler).performBadgeAchievements(prefix);
		container.removeAllItems();
		for (int i=0;i< listAchievements.size();i++){
			Object itemId = container.addItem();
			Item item = container.getItem(itemId);
			Property<String> itemProperty = item.getItemProperty(LabelAch);
			int numTask = i+1;
			itemProperty.setValue(numTask+" - "+listAchievements.get(i).getLabel());

		}

	}

	private List<Object> fillPopupTasks(String prefix, Container container){

		List<NamedIdentifier> listUserTasks = getListUserTasks(prefix);
		List<Object> listItemId = new ArrayList<Object>();
		List<NamedIdentifier> listTasks = getListTasks(prefix);
		container.removeAllItems();
		for (int i=0;i< listTasks.size();i++){
			Object itemId = container.addItem();
			Item item = container.getItem(itemId);
			Property<String> itemProperty = item.getItemProperty(LabelTasks);
			int numTask = i+1;
			itemProperty.setValue(numTask+" - "+listTasks.get(i).getLabel());
			//For testing
			//// FIXME TODO to remove after tests
			//if (i==1){
			//	listUserTasks.add(listTasks.get(i));
			//}

			if (listUserTasks.contains(listTasks.get(i))) listItemId.add(itemId);
		}
		return listItemId;

	}

	private void updateDesignTableTasksOERCreator(List<Object> listItemId){
		this.design.getTableTasksOERCreator().setCellStyleGenerator(new Table.CellStyleGenerator() {

			@Override
			public String getStyle(Table source, Object itemId, Object propertyId) {
				if (listItemId.contains(itemId)){
					return "green";
				}
				else return "black";
			}
		});

	}

	private void updateDesignTableTasksReviewer(List<Object> listItemId){
		this.design.getTableTasksReviewer().setCellStyleGenerator(new Table.CellStyleGenerator() {

			@Override
			public String getStyle(Table source, Object itemId, Object propertyId) {
				if (listItemId.contains(itemId)){
					return "red";
				}
				else return "black";
			}
		});

	}

	private void updateDesignTableTasksNetworker(List<Object> listItemId){
		this.design.getTableTasksReviewer().setCellStyleGenerator(new Table.CellStyleGenerator() {

			@Override
			public String getStyle(Table source, Object itemId, Object propertyId) {
				if (listItemId.contains(itemId)){
					return "blue";
				}
				else return "black";
			}
		});

	}




	private float initProgressBarValue(UserBadgeType badgeType, String prefix){

		List<NamedIdentifier> listTasks = getListTasks(prefix);
		List<NamedIdentifier> listUserTasks  = getListUserTasks(prefix);
		float nbrTasksTotal = listTasks.size();
		float nbrTasksDone = 0.0f;
		float delta = 0.0f;
		
		if (listUserTasks!=null && listTasks!=null){
		for (int i=0; i< listUserTasks.size();i++){
			if (listTasks.contains(listUserTasks.get(i)))
				nbrTasksDone++;
		}
		if (nbrTasksTotal != 0.0f)
			delta = (nbrTasksDone/nbrTasksTotal)/4;
		}

		if (badgeType != null) {
			if (badgeType.toString().endsWith("NOVICE")){

				return (0.25f+delta);
			}
			else if (badgeType.toString().endsWith("INTERMEDIATE")){
				return (0.5f+delta);
			}
			else if (badgeType.toString().endsWith("ADVANCED")){
				return (0.75f+delta);
			}
			else if (badgeType.toString().endsWith("EXPERT")){
				return 1.0f;
			}
		}
		return (0.0f+delta);
	}



	private List<NamedIdentifier> getListUserTasks(String prefix){
		if (prefix.equals("OER_CREATOR"))
			return listUserTasksOERCreator;
		else if (prefix.equals("REVIEWER"))
			return listUserTasksReviewer;
		else 
			return listUserTasksNetworker;
	}


	private List<NamedIdentifier> getListTasks(String prefix){
		if (prefix.equals("OER_CREATOR"))
			return listTasksOERCreator;
		else if (prefix.equals("REVIEWER"))
			return listTasksReviewer;
		else 
			return listTasksNetworker;

	}

	private UserBadgeType getUserBadgeType(String prefix){
		if (prefix.equals("OER_CREATOR"))
			return badgeTypeOERCreator;
		else if (prefix.equals("REVIEWER"))
			return badgeTypeReviewer;
		else 
			return badgeTypeNetworker;

	}








}
