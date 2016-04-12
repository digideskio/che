/*******************************************************************************
 * Copyright (c) 2012-2016 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.ide.ext.java.client.project.properties.valueproviders.entry;

import com.google.inject.ImplementedBy;

import org.eclipse.che.ide.api.mvp.View;

import javax.validation.constraints.NotNull;

/**
 * The interface which provides methods which allow change behaviour of the widget and answer on user actions(clicks).
 *
 * @author Valeriy Svydenko
 */
@ImplementedBy(NodeWidget.class)
public interface NodeEntry extends View<NodeEntry.ActionDelegate> {
    interface ActionDelegate {
        /**
         * Performs some actions when user click on entry.
         *
         * @param nodeWidget
         *         widget of the added node which was selected
         */
        void onNodeClicked(@NotNull NodeWidget nodeWidget);
    }
}
