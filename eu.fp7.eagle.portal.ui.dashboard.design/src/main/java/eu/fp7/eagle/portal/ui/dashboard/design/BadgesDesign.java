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
package eu.fp7.eagle.portal.ui.dashboard.design;

import com.vaadin.ui.Component;
import com.vaadin.ui.Image;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;


/**
 * @author Kheira Acem [kheira.acem@list.lu]
 * @since Sep 20, 2016 (1.0.0)
 * @version 1.0.0
 */
public interface BadgesDesign extends Component {

	
	/**
	 * 
	 */
	Image getImageBadgeOC(); 
	
	/**
	 * 
	 */
	VerticalLayout getBarLayoutOERCreator();
	
	/**
	 * 
	 */
	PopupView getPopupViewAchOERCreator();
	
	/**
	 * 
	 */
	PopupView getPopupViewTasksOERCreator();
	
	/**
	 * 
	 */
	Table getTableAchOERCreator();
	
	/**
	 * 
	 */
	Table getTableTasksOERCreator();
	
	/**
	 * 
	 */
	ProgressBar getProgressBarOERCreator();
	
	/**
	 * 
	 */
	Image getImageBadgeRev(); 
	
	/**
	 * 
	 */
	VerticalLayout getBarLayoutReviewer();
	
	/**
	 * 
	 */
	PopupView getPopupViewAchReviewer();
	
	/**
	 * 
	 */
	PopupView getPopupViewTasksReviewer();
	
	/**
	 * 
	 */
	Table getTableAchReviewer();
	
	/**
	 * 
	 */
	Table getTableTasksReviewer();
	
	/**
	 * 
	 */
	ProgressBar getProgressBarReviewer();
	
	/**
	 * 
	 */
	Image getImageBadgeNet(); 
	
	/**
	 * 
	 */
	VerticalLayout getBarLayoutNetworker();
	
	/**
	 * 
	 */
	PopupView getPopupViewAchNetworker();
	
	/**
	 * 
	 */
	PopupView getPopupViewTasksNetworker();
	
	/**
	 * 
	 */
	Table getTableAchNetworker();
	
	/**
	 * 
	 */
	Table getTableTasksNetworker();
	
	/**
	 * 
	 */
	ProgressBar getProgressBarNetworker();
	
	
}
