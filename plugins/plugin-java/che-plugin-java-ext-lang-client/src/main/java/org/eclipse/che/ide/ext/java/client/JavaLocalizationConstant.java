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
package org.eclipse.che.ide.ext.java.client;

import com.google.gwt.i18n.client.Messages;

/**
 * Localization constants. Interface to represent the constants defined in resource bundle:
 * 'JavaLocalizationConstant.properties'.
 *
 * @author Artem Zatsarynnyi
 */
public interface JavaLocalizationConstant extends Messages {
    /* NewJavaClassView */
    @Key("title")
    String title();

    @Key("ok")
    String buttonOk();

    @Key("cancel")
    String buttonCancel();

    /* Actions */
    @Key("action.newClass.title")
    String actionNewClassTitle();

    @Key("action.newClass.description")
    String actionNewClassDescription();

    @Key("action.newPackage.title")
    String actionNewPackageTitle();

    @Key("action.newPackage.description")
    String actionNewPackageDescription();

    @Key("messages.dependencies.successfully.updated")
    String dependenciesSuccessfullyUpdated();

    @Key("messages.dependencies.updating.dependencies")
    String updatingDependencies(String project);

    @Key("messages.dependencies.fail.updated")
    String updateDependenciesFailed();

    @Key("dependencies.output.tab.title")
    String dependenciesOutputTabTitle(String modulePath);

    @Key("action.quickdoc.title")
    String actionQuickdocTitle();

    @Key("action.quickdoc.description")
    String actionQuickdocDescription();

    @Key("action.quick.fix.title")
    String actionQuickFixTitle();

    @Key("action.quick.fix.description")
    String actionQuickFixDescription();

    @Key("action.openDeclaration.title")
    String actionOpenDeclarationTitle();

    @Key("action.openDeclaration.description")
    String actionOpenDeclarationDescription();

    @Key("compiler.error.warnings.setup")
    String compilerSetup();

    @Key("property.unused.local")
    String propertyUnusedLocal();

    @Key("property.unused.import")
    String propertyUnusedImport();

    @Key("property.dead.code")
    String propertyDeadCode();

    @Key("property.with.constructor.name")
    String propertyWithConstructorName();

    @Key("property.unnecessary.else")
    String propertyUnnecessaryElse();

    @Key("comparing.identical.values")
    String comparingIdenticalValues();

    @Key("no.effect.assignment")
    String noEffectAssignment();

    @Key("missing.serial.version.uid")
    String missingSerialVersionUid();

    @Key("type.parameter.hide.another.type")
    String typeParameterHideAnotherType();

    @Key("field.hides.another.field")
    String fieldHidesAnotherField();

    @Key("missing.switch.default.case")
    String missingSwitchDefaultCase();

    @Key("unused.private.member")
    String unusedPrivateMember();

    @Key("unchecked.type.operation")
    String uncheckedTypeOperation();

    @Key("usage.raw.type")
    String usageRawType();

    @Key("missing.override.annotation")
    String missingOverrideAnnotation();

    @Key("null.pointer.access")
    String nullPointerAccess();

    @Key("potential.null.pointer.access")
    String potentialNullPointerAccess();

    @Key("redundant.null.check")
    String redundantNullCheck();

    @Key("file.structure.action.name")
    String fileStructureActionName();

    @Key("file.structure.action.description")
    String fileStructureActionDescription();

    @Key("organize.imports.name")
    String organizeImportsName();

    @Key("organize.imports.description")
    String organizeImportsDescription();

    @Key("organize.imports.failed.title")
    String failedToProcessOrganizeImports();

    @Key("organize.imports.button.finish")
    String organizeImportsButtonFinish();

    @Key("organize.imports.button.cancel")
    String organizeImportsButtonCancel();

    @Key("organize.imports.button.next")
    String organizeImportsButtonNext();

    @Key("organize.imports.button.back")
    String organizeImportsButtonBack();

    @Key("show.inherited.members.label")
    String showInheritedMembersLabel();

    @Key("hide.inherited.members.label")
    String hideInheritedMembersLabel();

    @Key("move.action.name")
    String moveActionName();

    @Key("rename.refactoring.action.name")
    String renameRefactoringActionName();

    @Key("rename.dialog.title")
    String renameDialogTitle();

    @Key("rename.dialog.label")
    String renameDialogLabel();

    @Key("move.action.description")
    String moveActionDescription();

    @Key("move.div.tree.title")
    String moveDivTreeTitle();

    @Key("move.dialog.title")
    String moveDialogTitle();

    @Key("move.update.references")
    String moveUpdateReferences();

    @Key("move.update.full.names")
    String moveUpdateFullNames();

    @Key("move.file.name.patterns")
    String moveFileNamePatterns();

    @Key("move.patterns.info")
    String movePatternsInfo();

    @Key("move.dialog.button.ok")
    String moveDialogButtonOk();

    @Key("move.dialog.button.preview")
    String moveDialogButtonPreview();

    @Key("move.dialog.button.cancel")
    String moveDialogButtonCancel();

    @Key("move.dialog.button.back")
    String moveDialogButtonBack();

    @Key("multi.selection.destination")
    String multiSelectionDestination(int count);

    @Key("multi.selection.references")
    String multiSelectionReferences(int count);

    @Key("rename.error.editor")
    String renameErrorEditor();

    @Key("rename.loader")
    String renameLoader();

    @Key("move.preview.title")
    String movePreviewTitle();

    @Key("move.no.preview")
    String moveNoPreview();

    @Key("rename.update.references")
    String renameUpdateReferences();

    @Key("rename.update.occurrences")
    String renameUpdateOccurrences();

    @Key("rename.update.similarly.named.variables")
    String renameUpdateSimilarlyNamedVariables();

    @Key("rename.keep.original.method")
    String renameKeepOriginalMethod();

    @Key("rename.mark.deprecated")
    String renameMarkDeprecated();

    @Key("rename.subpackages")
    String renameSubpackages();

    @Key("rename.package.title")
    String renamePackageTitle();

    @Key("rename.type.title")
    String renameTypeTitle();

    @Key("rename.field.title")
    String renameFieldTitle();

    @Key("rename.method.title")
    String renameMethodTitle();

    @Key("rename.local.variable.title")
    String renameLocalVariableTitle();

    @Key("rename.enum.title")
    String renameEnumTitle();

    @Key("rename.type.variable.title")
    String renameTypeVariableTitle();

    @Key("rename.compilation.unit.title")
    String renameCompilationUnitTitle();

    @Key("rename.new.name")
    String renameNewName();

    @Key("rename.item.title")
    String renameItemTitle();

    @Key("rename.strategy")
    String renameStrategy();

    @Key("rename.find.exact.names")
    String renameFindExactNames();

    @Key("rename.find.name.suffixes")
    String renameFindNameSuffixes();

    @Key("rename.strategy.warning.label")
    String renameStrategyWarningLabel();

    @Key("rename.find.embedded.names")
    String renameFindEmbeddedNames();

    @Key("rename.similar.names.configuration.title")
    String renameSimilarNamesConfigurationTitle();

    @Key("rename.rename")
    String renameRename();

    @Key("rename.operation.unavailable")
    String renameOperationUnavailable();

    @Key("action.find.usages.title")
    String actionFindUsagesTitle();

    @Key("action.find.usages.description")
    String actionFindUsagesDescription();

    @Key("find.usages.part.title")
    String findUsagesPartTitle();

    @Key("find.usages.part.title.tooltip")
    String findUsagesPartTitleTooltip();

    @Key("rename.refactoring.action.description")
    String renameRefactoringActionDescription();

    @Key("failed.to.rename")
    String failedToRename();

    @Key("failed.to.process.refactoring.operation")
    String failedToProcessRefactoringOperation();

    @Key("failed.to.process.fin.usage")
    String failedToProcessFindUsage();

    @Key("open.implementation.action.name")
    String openImplementationActionName();

    @Key("open.implementation.action.description")
    String openImplementationDescription();

    @Key("open.implementation.window.title")
    String openImplementationWindowTitle(String declaration, int founded);

    @Key("open.implementation.no.implementations")
    String noImplementations();

    @Key("show.packages.error")
    String showPackagesError();

    @Key("show.preview.error")
    String showPreviewError();

    @Key("apply.move.error")
    String applyMoveError();

    @Key("warning.operation.title")
    String warningOperationTitle();

    @Key("warning.operation.content")
    String warningOperationContent();

    @Key("show.rename.wizard")
    String showRenameWizard();

    @Key("rename.with.warnings")
    String renameWithWarnings();

    @Key("unable.to.load.java.compiler.errors.warnings.settings")
    String unableToLoadJavaCompilerErrorsWarningsSettings();

    @Key("parameter.info")
    String parameterInfo();

    @Key("parameter.info.description")
    String parameterInfoDescription();
}
