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
package eu.fp7.eagle.portal.ui.dashboard.design.impl;



import com.vaadin.ui.CustomComponent;

import eu.fp7.eagle.portal.ui.dashboard.design.ActivitiesDesign;

import com.vaadin.ui.Label;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Table;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.GridLayout;


public class ActivitiesDesignImpl extends CustomComponent implements ActivitiesDesign {

	
	private static final long	serialVersionUID	= -7054127654779985202L;

	
	private VerticalLayout		verticalLayoutActivities;
	private GridLayout	gridLayoutSubjects;
	private GridLayout	gridLayoutResources;
	private Label 		labelTitle;
	
	
	public ActivitiesDesignImpl(VerticalLayout mainLayout) {
		this.buildActivitiesLayout(mainLayout);
		mainLayout.addComponent(verticalLayoutActivities);
		this.buildSubjectsLayout();
		verticalLayoutActivities.addComponent(gridLayoutSubjects);
		this.buildResourcesLayout();
		verticalLayoutActivities.addComponent(gridLayoutResources);
		
		
		// TODO add user code here
	}
	
	
	
	private VerticalLayout buildActivitiesLayout(VerticalLayout mainLayout){
		
		verticalLayoutActivities = new VerticalLayout();
		verticalLayoutActivities.setImmediate(false);
		verticalLayoutActivities.setWidth("100%");
		verticalLayoutActivities.setHeight("-1px");
		verticalLayoutActivities.setMargin(false);
		verticalLayoutActivities.setSpacing(false);
		labelTitle = new Label("Personal Activities");
		labelTitle.addStyleName("labelDashboardTitle");
		verticalLayoutActivities.addComponent(labelTitle);
		
		
		
		return verticalLayoutActivities;
	}
	
	private GridLayout buildSubjectsLayout(){
		
		gridLayoutSubjects = new GridLayout(8,1);
		gridLayoutSubjects.setImmediate(false);
		gridLayoutSubjects.setWidth("100%");
		gridLayoutSubjects.setHeight("-1px");
		gridLayoutSubjects.setSpacing(true);
		gridLayoutSubjects.setCaption("My Subjects");
		gridLayoutSubjects.addStyleName("gridLayoutSubjects");
		MarginInfo margin = new MarginInfo(true, false, true, false);
		gridLayoutSubjects.setMargin(margin);
		gridLayoutSubjects.setSpacing(false);
		gridLayoutSubjects.setColumnExpandRatio(7,1.0f);
		
		PopupView popup = new PopupView(null, buildTableActivity("Migration",3,2));
		popup.addStyleName("popupviewActivities");
		Button migration = new Button("Migration"+" "+"(5)",click -> popup.setPopupVisible(true));
		migration.addStyleName("buttonSubjectsListAct");
		gridLayoutSubjects.addComponent(migration,0,0);
		//popup.setWidth("100px");
		gridLayoutSubjects.addComponent(popup,1,0);

	
		PopupView popup2 = new PopupView(null, buildTableActivity("Housing",0,0));
		popup2.addStyleName("popupviewActivities");
		Button housing = new Button("Housing",click -> popup.setPopupVisible(false));
		housing.addStyleName("buttonSubjectsEmptyAct");
		gridLayoutSubjects.addComponent(housing,2,0);
		//popup2.setWidth("100px");
		gridLayoutSubjects.addComponent(popup2,3,0);

		
		return gridLayoutSubjects;
	}
	
	private GridLayout buildResourcesLayout(){
		
		gridLayoutResources = new GridLayout(8,1);
		gridLayoutResources.setImmediate(false);
		gridLayoutResources.setWidth("100%");
		gridLayoutResources.setHeight("-1px");
		gridLayoutResources.setSpacing(true);
		gridLayoutResources.setCaption("My Resources");
		gridLayoutResources.addStyleName("gridLayoutResources");
		MarginInfo margin = new MarginInfo(true, false, true, false);
		gridLayoutResources.setMargin(margin);
		gridLayoutResources.setSpacing(false);
		gridLayoutResources.setColumnExpandRatio(7,1.0f);

		
		PopupView popup = new PopupView(null, buildTableActivity("OER",2,2));
		popup.addStyleName("popupviewActivities");
		Button oer = new Button("OER"+" "+"(4)",click -> popup.setPopupVisible(true));
		oer.addStyleName("buttonResourcesListAct");
		gridLayoutResources.addComponent(oer,0,0);
		//popup.setWidth("100px");
		gridLayoutResources.addComponent(popup,1,0);

		PopupView popup2 = new PopupView(null, buildTableActivity("Wiki",1,2));
		popup2.addStyleName("popupviewActivities");
		Button wiki = new Button("Wiki"+" "+"(3)",click -> popup2.setPopupVisible(true));
		wiki.addStyleName("buttonResourcesListAct");
		gridLayoutResources.addComponent(wiki,2,0);
		popup2.setWidth("100px");
		gridLayoutResources.addComponent(popup2,3,0);

		PopupView popup3 = new PopupView(null, buildTableActivity("Blogs",0,0));
		popup3.addStyleName("popupviewActivities");
		Button blogs = new Button("Blogs",click -> popup3.setPopupVisible(false));
		blogs.addStyleName("buttonResourcesEmptyAct");
		gridLayoutResources.addComponent(blogs,4,0);
		//popup3.setWidth("100px");
		gridLayoutResources.addComponent(popup3,5,0);

		PopupView popup4 = new PopupView(null, buildTableActivity("Comments",5,5));
		popup4.addStyleName("popupviewActivities");
		Button comments = new Button("Comments"+" "+"(10)",click -> popup4.setPopupVisible(true));
		comments.addStyleName("buttonResourcesListAct");
		gridLayoutResources.addComponent(comments,6,0);
		//popup4.setWidth("100px");
		gridLayoutResources.addComponent(popup4,7,0);
	
		
		return gridLayoutResources;
	}
	
	private Table buildTableActivity(String activityGroupeName, Integer nbrAct1, Integer nbrAct2){
		Table table = new Table("");
		table.addContainerProperty("Activity Name", String.class, null);
		table.addContainerProperty("Occurrence number", Integer.class, null);
		table.addItem(new Object[]{"Activity 1",nbrAct1}, 1);
		table.addItem(new Object[]{"Activity 2",nbrAct2}, 2);
		return table;
	}

}