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
package org.eclipse.che.plugin.java.plain.server.projecttype;

import org.eclipse.che.api.project.server.FolderEntry;
import org.eclipse.che.api.project.server.type.ValueProvider;
import org.eclipse.che.api.project.server.type.ValueProviderFactory;
import org.eclipse.che.api.project.server.type.ValueStorageException;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.JavaModel;
import org.eclipse.jdt.internal.core.JavaModelManager;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.eclipse.che.ide.ext.java.shared.Constants.SOURCE_FOLDER;
import static org.eclipse.che.plugin.java.plain.shared.PlainJavaProjectConstants.DEFAULT_SOURCE_FOLDER_VALUE;
import static org.eclipse.jdt.core.IClasspathEntry.CPE_SOURCE;

/**
 * {@link ValueProviderFactory} for Plain Java project type.
 *
 * @author Valeriy Svydenko
 */
public class PlainJavaPropertiesValueProviderFactory implements ValueProviderFactory {
    @Override
    public ValueProvider newInstance(FolderEntry projectFolder) {
        return new JavaPropertiesValueProvider(projectFolder);
    }

    private class JavaPropertiesValueProvider implements ValueProvider {
        private FolderEntry projectFolder;

        public JavaPropertiesValueProvider(FolderEntry projectFolder) {
            this.projectFolder = projectFolder;
        }

        @Override
        public List<String> getValues(String attributeName) throws ValueStorageException {
            if (SOURCE_FOLDER.equals(attributeName)) {
                return getSourceFolders();
            }
            return null;
        }

        private List<String> getSourceFolders() throws ValueStorageException {
            List<String> sourceFolders = new ArrayList<>();

            String projectPath = projectFolder.getPath().toString();

            JavaModel model = JavaModelManager.getJavaModelManager().getJavaModel();
            IJavaProject project = model.getJavaProject(projectPath);

            try {
                IClasspathEntry[] classpath = project.getRawClasspath();

                for (IClasspathEntry entry : classpath) {
                    String entryPath = entry.getPath().toOSString();
                    if (CPE_SOURCE == entry.getEntryKind() && !entryPath.equals(projectPath)) {
                        if (entryPath.startsWith(projectPath)) {
                            sourceFolders.add(entryPath.substring(projectPath.length()));
                        } else {
                            sourceFolders.add(entryPath);
                        }
                    }
                }
            } catch (JavaModelException e) {
                throw new ValueStorageException(
                        "Classpath does not exist or an exception occurs while accessing its corresponding resource : " + e.getMessage());
            }

            return sourceFolders.isEmpty() ? singletonList(DEFAULT_SOURCE_FOLDER_VALUE) : sourceFolders;
        }
    }
}
