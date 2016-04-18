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
package org.eclipse.che.ide.ext.java.client.project.classpath.valueproviders.selectnode;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import org.eclipse.che.ide.ext.java.client.project.classpath.valueproviders.ClasspathPagePresenter;
import org.eclipse.che.ide.ext.java.client.project.classpath.valueproviders.selectnode.interceptors.ClasspathNodeInterceptor;
import org.eclipse.che.ide.ext.java.client.project.classpath.valueproviders.selectnode.interceptors.JarNodeInterceptor;
import org.eclipse.che.ide.part.explorer.project.ProjectExplorerPresenter;
import org.vectomatic.dom.svg.ui.SVGResource;

/**
 * Presenter for choosing directory for searching a node.
 *
 * @author Valeriy Svydenko
 */
@Singleton
public class SelectNodePresenter implements SelectNodeView.ActionDelegate {
    private final static String WORKSPACE_PATH = "/projects";

    private final SelectNodeView           view;
    private final ProjectExplorerPresenter projectExplorerPresenter;

    private ClasspathPagePresenter classpathPagePresenter;
    private ClasspathNodeInterceptor interceptor;

    @Inject
    public SelectNodePresenter(SelectNodeView view, ProjectExplorerPresenter projectExplorerPresenter) {
        this.view = view;
        this.projectExplorerPresenter = projectExplorerPresenter;
        this.view.setDelegate(this);
    }

    /**
     * Show tree view with all needed nodes of the workspace.
     *
     * @param pagePresenter
     *         delegate from the property page
     * @param nodeInterceptor
     *         interceptor for showing nodes
     */
    public void show(ClasspathPagePresenter pagePresenter, ClasspathNodeInterceptor nodeInterceptor) {
        this.classpathPagePresenter = pagePresenter;
        this.interceptor = nodeInterceptor;
        view.setStructure(projectExplorerPresenter.getRootNodes(), interceptor);
        view.show();
    }

    /** {@inheritDoc} */
    @Override
    public void setSelectedNode(String path, SVGResource icon) {
        if (interceptor instanceof JarNodeInterceptor) {
            path = WORKSPACE_PATH + path;
        }
        classpathPagePresenter.addNode(path, interceptor.getKind(), icon);
    }
}
