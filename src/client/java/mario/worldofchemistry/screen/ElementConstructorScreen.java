package mario.worldofchemistry.screen;

import mario.worldofchemistry.handler.ElementConstructorScreenHandler;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.screen.narration.NarrationPart;
import net.minecraft.client.gui.widget.PressableWidget;
import net.minecraft.client.gui.widget.SliderWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.glfw.GLFW;

import java.util.*;
import java.util.function.Consumer;

import static mario.worldofchemistry.WorldOfChemistry.MOD_ID;

public class ElementConstructorScreen extends HandledScreen<ElementConstructorScreenHandler> {

    private static final Identifier GUI_TEXTURE = Identifier.of(MOD_ID, "textures/gui/element_constructor.png");
    private static final Identifier MICROSCOPE_TEXTURE = Identifier.of(MOD_ID, "textures/gui/microscope.png");
    private static final Identifier PLACEHOLDER_ELEMENT_TEXTURE = Identifier.of(MOD_ID, "textures/gui/placeholder_element.png");

    private static final Identifier PLUS_BUTTON_DEFAULT_TEXTURE = Identifier.of(MOD_ID, "textures/gui/button_plus_default.png");
    private static final Identifier PLUS_BUTTON_HIGHLIGHT_TEXTURE = Identifier.of(MOD_ID, "textures/gui/button_plus_highlight.png");
    private static final Identifier PLUS_BUTTON_ACTIVE_TEXTURE = Identifier.of(MOD_ID, "textures/gui/button_plus_active.png");

    private static final Identifier MINUS_BUTTON_DEFAULT_TEXTURE = Identifier.of(MOD_ID, "textures/gui/button_minus_default.png");
    private static final Identifier MINUS_BUTTON_HIGHLIGHT_TEXTURE = Identifier.of(MOD_ID, "textures/gui/button_minus_highlight.png");
    private static final Identifier MINUS_BUTTON_ACTIVE_TEXTURE = Identifier.of(MOD_ID, "textures/gui/button_minus_active.png");

    private static final Identifier TEXT_FIELD_DEFAULT_TEXTURE = Identifier.of(MOD_ID, "textures/gui/text_field_default.png");
    private static final Identifier TEXT_FIELD_HIGHLIGHT_TEXTURE = Identifier.of(MOD_ID, "textures/gui/text_field_highlight.png");

    private static final Identifier SLIDER_THUMB_DEFAULT_TEXTURE = Identifier.of(MOD_ID, "textures/gui/vertical_slider_thumb_default.png");
    private static final Identifier SLIDER_THUMB_FOCUS_TEXTURE = Identifier.of(MOD_ID, "textures/gui/vertical_slider_thumb_focus.png");

    private static final int SLIDER_TRACK_EMPTY_COLOR = 0xFF555555;
    private static final int PROTON_SLIDER_FILL_COLOR = 0xFF5E74A7;
    private static final int ELECTRON_SLIDER_FILL_COLOR = 0xFFA7685E;
    private static final int NEUTRON_SLIDER_FILL_COLOR = 0xFFA88F61;
    private static final int SLIDER_TRACK_OUTLINE_DEFAULT = 0xFF353535;
    private static final int SLIDER_TRACK_OUTLINE_HOVERED = 0xFFB5B5B5;
    private static final int SLIDER_TRACK_OUTLINE_DISABLED = 0xFF353535;

    private static final int TEXT_FIELD_FONT_COLOR = 0xFFFFFFFF;

    private static final int BUTTON_SIZE = 12;
    private static final int SLIDER_WIDTH = 12;
    private static final int SLIDER_HEIGHT = 138;
    private static final int TEXT_FIELD_WIDTH = 24;
    private static final int TEXT_FIELD_HEIGHT = 20;
    private static final int COMPONENT_SPACING_VERTICAL = 2;
    private static final int COLUMN_EFFECTIVE_WIDTH = Math.max(SLIDER_WIDTH, TEXT_FIELD_WIDTH);
    private static final int INTER_COLUMN_SPACING = 2;

    private ValueTextFieldWidget protonTextField, neutronTextField, electronTextField;
    private CustomTexturedButton addProtonBtn, removeProtonBtn;
    private CustomTexturedButton addNeutronBtn, removeNeutronBtn;
    private CustomTexturedButton addElectronBtn, removeElectronBtn;
    private VerticalSliderWidget protonSlider, neutronSlider, electronSlider;

    private static final int PROTON_SLIDER_BUTTON_ID_OFFSET = 100;
    public static final int PROTON_MAX_VALUE = 120;
    private static final int NEUTRON_SLIDER_BUTTON_ID_OFFSET = 500;
    public static final int NEUTRON_MAX_VALUE = 180;
    private static final int ELECTRON_SLIDER_BUTTON_ID_OFFSET = 300;
    public static final int ELECTRON_MAX_VALUE = 120;
    private static final int MAX_TEXT_FIELD_LENGTH = 3;

    private static final Identifier PROTON_TEXTURE = Identifier.of(MOD_ID, "textures/gui/proton.png");
    private static final Identifier NEUTRON_TEXTURE = Identifier.of(MOD_ID, "textures/gui/neutron.png");
    private static final Identifier ELECTRON_TEXTURE = Identifier.of(MOD_ID, "textures/gui/electron.png");

    private static final int PARTICLE_TEXTURE_FILE_WIDTH = 9;
    private static final int PARTICLE_TEXTURE_FILE_HEIGHT = 9;

    private static final int GUI_ELEMENT_TEXTURE_FILE_WIDTH = 32;
    private static final int GUI_ELEMENT_TEXTURE_FILE_HEIGHT = 32;

    public ElementConstructorScreen(ElementConstructorScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 250;
        this.backgroundHeight = 220;
        this.playerInventoryTitleY = Integer.MAX_VALUE;
        this.titleY = 5;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int guiLeft = this.x;
        int guiTop = this.y;

        context.drawTexture(RenderPipelines.GUI_TEXTURED, GUI_TEXTURE, guiLeft, guiTop, 0, 0, this.backgroundWidth, this.backgroundHeight, this.backgroundWidth, this.backgroundHeight);

        Text labelP = Text.literal("p");
        Text labelE = Text.literal("e");
        Text labelN = Text.literal("n");
        int staticLabelYAbs = guiTop + 17;
        int labelTextColor = 0xFF4C4C4C;

        int col1LabelXAbs = guiLeft - 3 + (COLUMN_EFFECTIVE_WIDTH - this.textRenderer.getWidth(labelP)) / 2;
        int col2LabelXAbs = guiLeft - 3 + COLUMN_EFFECTIVE_WIDTH + INTER_COLUMN_SPACING + (COLUMN_EFFECTIVE_WIDTH - this.textRenderer.getWidth(labelE)) / 2;
        int col3LabelXAbs = guiLeft - 3 + (COLUMN_EFFECTIVE_WIDTH + INTER_COLUMN_SPACING) * 2 + (COLUMN_EFFECTIVE_WIDTH - this.textRenderer.getWidth(labelN)) / 2;

        context.drawText(this.textRenderer, labelP, col1LabelXAbs, staticLabelYAbs, labelTextColor, false);
        context.drawText(this.textRenderer, labelE, col2LabelXAbs, staticLabelYAbs, labelTextColor, false);
        context.drawText(this.textRenderer, labelN, col3LabelXAbs, staticLabelYAbs, labelTextColor, false);

        int spriteDisplayWidth = 8; int spriteDisplayHeight = 8; float u=0f, v=0f;
        int protonIconXAbs = guiLeft + 12;
        int protonIconYAbs = guiTop + 17;
        context.drawTexture(RenderPipelines.GUI_TEXTURED, PROTON_TEXTURE, protonIconXAbs, protonIconYAbs, u, v, spriteDisplayWidth, spriteDisplayHeight, PARTICLE_TEXTURE_FILE_WIDTH, PARTICLE_TEXTURE_FILE_HEIGHT, PARTICLE_TEXTURE_FILE_WIDTH, PARTICLE_TEXTURE_FILE_HEIGHT);
        int electronIconXAbs = protonIconXAbs + spriteDisplayWidth + 18;
        context.drawTexture(RenderPipelines.GUI_TEXTURED, ELECTRON_TEXTURE, electronIconXAbs, protonIconYAbs, u, v, spriteDisplayWidth, spriteDisplayHeight, PARTICLE_TEXTURE_FILE_WIDTH, PARTICLE_TEXTURE_FILE_HEIGHT, PARTICLE_TEXTURE_FILE_WIDTH, PARTICLE_TEXTURE_FILE_HEIGHT);
        int neutronIconXAbs = electronIconXAbs + spriteDisplayWidth + 18;
        context.drawTexture(RenderPipelines.GUI_TEXTURED, NEUTRON_TEXTURE, neutronIconXAbs, protonIconYAbs, u, v, spriteDisplayWidth, spriteDisplayHeight, PARTICLE_TEXTURE_FILE_WIDTH, PARTICLE_TEXTURE_FILE_HEIGHT, PARTICLE_TEXTURE_FILE_WIDTH, PARTICLE_TEXTURE_FILE_HEIGHT);

        context.drawTexture(RenderPipelines.GUI_TEXTURED, MICROSCOPE_TEXTURE, guiLeft + 194, guiTop + 18, u, v, 50, 50, GUI_ELEMENT_TEXTURE_FILE_WIDTH, GUI_ELEMENT_TEXTURE_FILE_HEIGHT, GUI_ELEMENT_TEXTURE_FILE_WIDTH, GUI_ELEMENT_TEXTURE_FILE_HEIGHT);
        context.drawTexture(RenderPipelines.GUI_TEXTURED, PLACEHOLDER_ELEMENT_TEXTURE, guiLeft + 212, guiTop + 90, u,v, 16,16, GUI_ELEMENT_TEXTURE_FILE_WIDTH, GUI_ELEMENT_TEXTURE_FILE_HEIGHT, GUI_ELEMENT_TEXTURE_FILE_WIDTH, GUI_ELEMENT_TEXTURE_FILE_HEIGHT);

    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);

        int currentProtons = this.handler.getProtons();
        int currentElectrons = this.handler.getElectrons();
        int currentNeutrons = this.handler.getNeutrons();

        if (this.protonSlider != null && !this.protonSlider.isCurrentlyDragging()) this.protonSlider.setActualValue(currentProtons);
        if (this.electronSlider != null && !this.electronSlider.isCurrentlyDragging()) this.electronSlider.setActualValue(currentElectrons);
        if (this.neutronSlider != null && !this.neutronSlider.isCurrentlyDragging()) this.neutronSlider.setActualValue(currentNeutrons);

        if (this.protonTextField != null && !this.protonTextField.isFocused() && (this.protonSlider != null && !this.protonSlider.isCurrentlyDragging())) {
            this.protonTextField.setTextFromServer(String.valueOf(currentProtons));
        }
        if (this.electronTextField != null && !this.electronTextField.isFocused() && (this.electronSlider != null && !this.electronSlider.isCurrentlyDragging())) {
            this.electronTextField.setTextFromServer(String.valueOf(currentElectrons));
        }
        if (this.neutronTextField != null && !this.neutronTextField.isFocused() && (this.neutronSlider != null && !this.neutronSlider.isCurrentlyDragging())) {
            this.neutronTextField.setTextFromServer(String.valueOf(currentNeutrons));
        }
        if (this.addProtonBtn != null) this.addProtonBtn.active = true;

    }

    @Override
    public void mouseMoved(double mouseX, double mouseY) {
        super.mouseMoved(mouseX, mouseY);

        Element currentFocusedWidget = this.getFocused();
        Element widgetDirectlyUnderMouse = null;

        for (Element child : this.children()) {
            if (child instanceof PressableWidget || child instanceof SliderWidget || child instanceof TextFieldWidget) {
                if (child.isMouseOver(mouseX, mouseY)) {
                    if (child instanceof net.minecraft.client.gui.widget.ClickableWidget clickable) {
                        if (clickable.active && clickable.visible) {
                            widgetDirectlyUnderMouse = child;
                            break;
                        }
                    } else {
                        widgetDirectlyUnderMouse = child;
                        break;
                    }
                }
            }
        }

        if (widgetDirectlyUnderMouse != null) {
            if (currentFocusedWidget != widgetDirectlyUnderMouse) {
                if (currentFocusedWidget instanceof VerticalSliderWidget oldSlider && oldSlider.isKeyboardMoveMode) {
                    oldSlider.isKeyboardMoveMode = false;
                }
                this.setFocused(widgetDirectlyUnderMouse);
            }

        } else {
            if (currentFocusedWidget != null && currentFocusedWidget != this) {

                if (currentFocusedWidget instanceof VerticalSliderWidget currentSlider) {
                    if (currentSlider.isKeyboardMoveMode) {
                        currentSlider.isKeyboardMoveMode = false;
                    }
                    if (!currentSlider.isCurrentlyDragging()) {
                        this.setFocused(null);
                    }
                } else if (currentFocusedWidget instanceof CustomTexturedButton) {
                    this.setFocused(null);
                }
            }
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        Element previouslyFocusedWidget = this.getFocused();

        ValueTextFieldWidget previouslyFocusedTF = null;
        if (previouslyFocusedWidget instanceof ValueTextFieldWidget && previouslyFocusedWidget.isFocused()) {
            previouslyFocusedTF = (ValueTextFieldWidget) previouslyFocusedWidget;
        }

        boolean handledByChild = super.mouseClicked(mouseX, mouseY, button);

        Element currentFocusedWidget = this.getFocused();

        if (previouslyFocusedWidget instanceof VerticalSliderWidget oldSlider &&
                oldSlider.isKeyboardMoveMode &&
                previouslyFocusedWidget != currentFocusedWidget) {
            oldSlider.isKeyboardMoveMode = false;
        }

        if (previouslyFocusedTF != null && previouslyFocusedTF != currentFocusedWidget && !(currentFocusedWidget instanceof ValueTextFieldWidget)) {
            int buttonIdOffset = 0; int minValue = 0; int maxValue = 0;
            if (previouslyFocusedTF == this.protonTextField) { buttonIdOffset = PROTON_SLIDER_BUTTON_ID_OFFSET; maxValue = PROTON_MAX_VALUE; }
            else if (previouslyFocusedTF == this.electronTextField) { buttonIdOffset = ELECTRON_SLIDER_BUTTON_ID_OFFSET; maxValue = ELECTRON_MAX_VALUE; }
            else if (previouslyFocusedTF == this.neutronTextField) { buttonIdOffset = NEUTRON_SLIDER_BUTTON_ID_OFFSET; maxValue = NEUTRON_MAX_VALUE; }

            if (previouslyFocusedTF == this.protonTextField || previouslyFocusedTF == this.electronTextField || previouslyFocusedTF == this.neutronTextField) {
                finalizeTextFieldValue(previouslyFocusedTF, previouslyFocusedTF.getText(), buttonIdOffset, minValue, maxValue);
            }
        }
        return handledByChild;
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {

        boolean protonWasDragging = this.protonSlider != null && this.protonSlider.isCurrentlyDragging();
        boolean electronWasDragging = this.electronSlider != null && this.electronSlider.isCurrentlyDragging();
        boolean neutronWasDragging = this.neutronSlider != null && this.neutronSlider.isCurrentlyDragging();

        boolean eventHandledBySuperChain = super.mouseReleased(mouseX, mouseY, button);

        boolean sliderFinalized = false;

        if (button == 0) {
            if (protonWasDragging && this.protonSlider.isCurrentlyDragging()) {
                this.protonSlider.mouseReleased(mouseX, mouseY, button);
                sliderFinalized = true;
            }
            if (electronWasDragging && this.electronSlider.isCurrentlyDragging()) {
                this.electronSlider.mouseReleased(mouseX, mouseY, button);
                sliderFinalized = true;
            }
            if (neutronWasDragging && this.neutronSlider.isCurrentlyDragging()) {
                this.neutronSlider.mouseReleased(mouseX, mouseY, button);
                sliderFinalized = true;
            }
        }

        return eventHandledBySuperChain || sliderFinalized;
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        Element focusedElement = this.getFocused();
        if (focusedElement instanceof ValueTextFieldWidget focusedTf) {
            if (focusedTf.keyPressed(keyCode, scanCode, modifiers)) {
                return true;
            }
        }
        if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
            if (this.shouldCloseOnEsc()) {
                this.close();
                return true;
            }
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
        Element focusedElement = this.getFocused();
        if (focusedElement instanceof CustomTexturedButton btn) {
            btn.handleKeyboardRelease(keyCode);
        }
        return super.keyReleased(keyCode, scanCode, modifiers);
    }

    private void unfocusAllValueTextFields() {
        if (this.protonTextField != null && this.protonTextField.isFocused()) this.protonTextField.setFocused(false);
        if (this.electronTextField != null && this.electronTextField.isFocused()) this.electronTextField.setFocused(false);
        if (this.neutronTextField != null && this.neutronTextField.isFocused()) this.neutronTextField.setFocused(false);
    }

    @Override
    protected void init() {
        super.init();
        this.titleX = (this.backgroundWidth - this.textRenderer.getWidth(this.title)) / 2;

        int panelX = (this.width - this.backgroundWidth) / 2;
        int panelY = (this.height - this.backgroundHeight) / 2;

        int col1WidgetsX = panelX + 4;
        int col2WidgetsX = col1WidgetsX + COLUMN_EFFECTIVE_WIDTH + INTER_COLUMN_SPACING;
        int col3WidgetsX = col2WidgetsX + COLUMN_EFFECTIVE_WIDTH + INTER_COLUMN_SPACING;

        int staticLabelYScreen = panelY + 20;
        int valueTextFieldYScreen = staticLabelYScreen + this.textRenderer.fontHeight + COMPONENT_SPACING_VERTICAL;
        int plusButtonYScreen = valueTextFieldYScreen + TEXT_FIELD_HEIGHT + COMPONENT_SPACING_VERTICAL;
        int sliderTopYScreen = plusButtonYScreen + BUTTON_SIZE;
        int minusButtonYScreen = sliderTopYScreen + SLIDER_HEIGHT;

        this.protonTextField = createValueTextField(
                col1WidgetsX + (COLUMN_EFFECTIVE_WIDTH - TEXT_FIELD_WIDTH) / 2, valueTextFieldYScreen,
                this.handler.getProtons(), PROTON_SLIDER_BUTTON_ID_OFFSET, 0, PROTON_MAX_VALUE,
                Text.translatable("gui." + MOD_ID + ".element_constructor.protons_value"), TEXT_FIELD_DEFAULT_TEXTURE, TEXT_FIELD_HIGHLIGHT_TEXTURE);
        this.addDrawableChild(this.protonTextField);

        this.addProtonBtn = new CustomTexturedButton(
                col1WidgetsX + (COLUMN_EFFECTIVE_WIDTH - BUTTON_SIZE) / 2, plusButtonYScreen, BUTTON_SIZE, BUTTON_SIZE,
                PLUS_BUTTON_DEFAULT_TEXTURE, PLUS_BUTTON_HIGHLIGHT_TEXTURE, PLUS_BUTTON_ACTIVE_TEXTURE,
                Text.translatable("gui." + MOD_ID + ".element_constructor.increment_protons"), (button) -> {
            unfocusAllValueTextFields();
            clickButtonServer(0);
        });
        this.addDrawableChild(this.addProtonBtn);

        this.protonSlider = new VerticalSliderWidget(
                col1WidgetsX + (COLUMN_EFFECTIVE_WIDTH - SLIDER_WIDTH) / 2, sliderTopYScreen, SLIDER_WIDTH, SLIDER_HEIGHT,
                0, PROTON_MAX_VALUE, this.handler.getProtons(),
                (value) -> {
                    unfocusAllValueTextFields();
                    clickButtonServer(PROTON_SLIDER_BUTTON_ID_OFFSET + value);
                },
                (liveValue) -> {
                    if (this.protonTextField != null && !this.protonTextField.isFocused()) {
                        this.protonTextField.setTextFromSliderDrag(String.valueOf(liveValue));
                    }
                },
                SLIDER_THUMB_DEFAULT_TEXTURE, SLIDER_THUMB_FOCUS_TEXTURE,
                PROTON_SLIDER_FILL_COLOR, SLIDER_TRACK_EMPTY_COLOR,
                SLIDER_TRACK_OUTLINE_DEFAULT, SLIDER_TRACK_OUTLINE_HOVERED, SLIDER_TRACK_OUTLINE_DISABLED);
        this.addDrawableChild(this.protonSlider);

        this.removeProtonBtn = new CustomTexturedButton(
                col1WidgetsX + (COLUMN_EFFECTIVE_WIDTH - BUTTON_SIZE) / 2, minusButtonYScreen, BUTTON_SIZE, BUTTON_SIZE,
                MINUS_BUTTON_DEFAULT_TEXTURE, MINUS_BUTTON_HIGHLIGHT_TEXTURE, MINUS_BUTTON_ACTIVE_TEXTURE,
                Text.translatable("gui." + MOD_ID + ".element_constructor.decrement_protons"), (button) -> {
            unfocusAllValueTextFields();
            clickButtonServer(1);
        });
        this.addDrawableChild(this.removeProtonBtn);

        this.electronTextField = createValueTextField(
                col2WidgetsX + (COLUMN_EFFECTIVE_WIDTH - TEXT_FIELD_WIDTH) / 2, valueTextFieldYScreen,
                this.handler.getElectrons(), ELECTRON_SLIDER_BUTTON_ID_OFFSET, 0, ELECTRON_MAX_VALUE,
                Text.translatable("gui." + MOD_ID + ".element_constructor.electrons_value"), TEXT_FIELD_DEFAULT_TEXTURE, TEXT_FIELD_HIGHLIGHT_TEXTURE);
        this.addDrawableChild(this.electronTextField);

        this.addElectronBtn = new CustomTexturedButton(
                col2WidgetsX + (COLUMN_EFFECTIVE_WIDTH - BUTTON_SIZE) / 2, plusButtonYScreen, BUTTON_SIZE, BUTTON_SIZE,
                PLUS_BUTTON_DEFAULT_TEXTURE, PLUS_BUTTON_HIGHLIGHT_TEXTURE, PLUS_BUTTON_ACTIVE_TEXTURE,
                Text.translatable("gui." + MOD_ID + ".element_constructor.increment_electrons"), (button) -> {
            unfocusAllValueTextFields();
            clickButtonServer(4);
        });
        this.addDrawableChild(this.addElectronBtn);

        this.electronSlider = new VerticalSliderWidget(
                col2WidgetsX + (COLUMN_EFFECTIVE_WIDTH - SLIDER_WIDTH) / 2, sliderTopYScreen, SLIDER_WIDTH, SLIDER_HEIGHT,
                0, ELECTRON_MAX_VALUE, this.handler.getElectrons(),
                (value) -> {
                    unfocusAllValueTextFields();
                    clickButtonServer(ELECTRON_SLIDER_BUTTON_ID_OFFSET + value);
                },
                (liveValue) -> {
                    if (this.electronTextField != null && !this.electronTextField.isFocused()) {
                        this.electronTextField.setTextFromSliderDrag(String.valueOf(liveValue));
                    }
                },
                SLIDER_THUMB_DEFAULT_TEXTURE, SLIDER_THUMB_FOCUS_TEXTURE,
                ELECTRON_SLIDER_FILL_COLOR, SLIDER_TRACK_EMPTY_COLOR,
                SLIDER_TRACK_OUTLINE_DEFAULT, SLIDER_TRACK_OUTLINE_HOVERED, SLIDER_TRACK_OUTLINE_DISABLED);
        this.addDrawableChild(this.electronSlider);

        this.removeElectronBtn = new CustomTexturedButton(
                col2WidgetsX + (COLUMN_EFFECTIVE_WIDTH - BUTTON_SIZE) / 2, minusButtonYScreen, BUTTON_SIZE, BUTTON_SIZE,
                MINUS_BUTTON_DEFAULT_TEXTURE, MINUS_BUTTON_HIGHLIGHT_TEXTURE, MINUS_BUTTON_ACTIVE_TEXTURE,
                Text.translatable("gui." + MOD_ID + ".element_constructor.decrement_electrons"), (button) -> {
            unfocusAllValueTextFields();
            clickButtonServer(5);
        });
        this.addDrawableChild(this.removeElectronBtn);

        this.neutronTextField = createValueTextField(
                col3WidgetsX + (COLUMN_EFFECTIVE_WIDTH - TEXT_FIELD_WIDTH) / 2, valueTextFieldYScreen,
                this.handler.getNeutrons(), NEUTRON_SLIDER_BUTTON_ID_OFFSET, 0, NEUTRON_MAX_VALUE,
                Text.translatable("gui." + MOD_ID + ".element_constructor.neutrons_value"), TEXT_FIELD_DEFAULT_TEXTURE, TEXT_FIELD_HIGHLIGHT_TEXTURE);
        this.addDrawableChild(this.neutronTextField);

        this.addNeutronBtn = new CustomTexturedButton(
                col3WidgetsX + (COLUMN_EFFECTIVE_WIDTH - BUTTON_SIZE) / 2, plusButtonYScreen, BUTTON_SIZE, BUTTON_SIZE,
                PLUS_BUTTON_DEFAULT_TEXTURE, PLUS_BUTTON_HIGHLIGHT_TEXTURE, PLUS_BUTTON_ACTIVE_TEXTURE,
                Text.translatable("gui." + MOD_ID + ".element_constructor.increment_neutrons"), (button) -> {
            unfocusAllValueTextFields();
            clickButtonServer(2);
        });
        this.addDrawableChild(this.addNeutronBtn);

        this.neutronSlider = new VerticalSliderWidget(
                col3WidgetsX + (COLUMN_EFFECTIVE_WIDTH - SLIDER_WIDTH) / 2, sliderTopYScreen, SLIDER_WIDTH, SLIDER_HEIGHT,
                0, NEUTRON_MAX_VALUE, this.handler.getNeutrons(),
                (value) -> {
                    unfocusAllValueTextFields();
                    clickButtonServer(NEUTRON_SLIDER_BUTTON_ID_OFFSET + value);
                },
                (liveValue) -> {
                    if (this.neutronTextField != null && !this.neutronTextField.isFocused()) {
                        this.neutronTextField.setTextFromSliderDrag(String.valueOf(liveValue));
                    }
                },
                SLIDER_THUMB_DEFAULT_TEXTURE, SLIDER_THUMB_FOCUS_TEXTURE,
                NEUTRON_SLIDER_FILL_COLOR, SLIDER_TRACK_EMPTY_COLOR,
                SLIDER_TRACK_OUTLINE_DEFAULT, SLIDER_TRACK_OUTLINE_HOVERED, SLIDER_TRACK_OUTLINE_DISABLED);
        this.addDrawableChild(this.neutronSlider);

        this.removeNeutronBtn = new CustomTexturedButton(
                col3WidgetsX + (COLUMN_EFFECTIVE_WIDTH - BUTTON_SIZE) / 2, minusButtonYScreen, BUTTON_SIZE, BUTTON_SIZE,
                MINUS_BUTTON_DEFAULT_TEXTURE, MINUS_BUTTON_HIGHLIGHT_TEXTURE, MINUS_BUTTON_ACTIVE_TEXTURE,
                Text.translatable("gui." + MOD_ID + ".element_constructor.decrement_neutrons"), (button) -> {
            unfocusAllValueTextFields();
            clickButtonServer(3);
        });
        this.addDrawableChild(this.removeNeutronBtn);
    }

    private ValueTextFieldWidget createValueTextField(int x, int y, int initialValue, int buttonIdOffset, int minValue, int maxValue, Text narrationMessage,
                                                      Identifier normalTexture, Identifier hoveredTexture) {
        final ValueTextFieldWidget[] textFieldHolder = new ValueTextFieldWidget[1];
        textFieldHolder[0] = new ValueTextFieldWidget(
                this.textRenderer, x, y, TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT, narrationMessage,
                (textFromSubmit) -> {
                    if (textFieldHolder[0] != null) {
                        finalizeTextFieldValue(textFieldHolder[0], textFromSubmit, buttonIdOffset, minValue, maxValue);
                    }
                },
                normalTexture, hoveredTexture
        );
        ValueTextFieldWidget textField = textFieldHolder[0];
        textField.setMaxLength(MAX_TEXT_FIELD_LENGTH);
        textField.setTextFromServer(String.valueOf(initialValue));
        textField.setTextPredicate(s -> s.isEmpty() || s.matches("-?\\d*"));
        textField.setEditableColor(TEXT_FIELD_FONT_COLOR);
        return textField;
    }

    private void finalizeTextFieldValue(TextFieldWidget textField, String text, int buttonIdOffset, int minValue, int maxValue) {
        int currentValueInHandler;
        if (buttonIdOffset == PROTON_SLIDER_BUTTON_ID_OFFSET) currentValueInHandler = this.handler.getProtons();
        else if (buttonIdOffset == ELECTRON_SLIDER_BUTTON_ID_OFFSET) currentValueInHandler = this.handler.getElectrons();
        else if (buttonIdOffset == NEUTRON_SLIDER_BUTTON_ID_OFFSET) currentValueInHandler = this.handler.getNeutrons();
        else {
            System.err.println("Unknown buttonIdOffset in finalizeTextFieldValue: " + buttonIdOffset);
            return;
        }

        try {
            int value = text.isEmpty() ? minValue : Integer.parseInt(text);
            int clampedValue = MathHelper.clamp(value, minValue, maxValue);

            if (textField instanceof ValueTextFieldWidget vtf) {
                vtf.setTextFromServer(String.valueOf(clampedValue));
            } else {
                textField.setText(String.valueOf(clampedValue));
            }

            if (clampedValue != currentValueInHandler) {
                clickButtonServer(buttonIdOffset + clampedValue);
            }
        } catch (NumberFormatException e) {
            if (textField instanceof ValueTextFieldWidget vtf) {
                vtf.setTextFromServer(String.valueOf(currentValueInHandler));
            } else {
                textField.setText(String.valueOf(currentValueInHandler));
            }
        }
    }

    private void clickButtonServer(int buttonId) {
        if (this.client != null && this.client.interactionManager != null && this.handler != null) {
            this.client.interactionManager.clickButton(this.handler.syncId, buttonId);
        }
    }

    public static class CustomTexturedButton extends PressableWidget {
        private final Identifier textureDefault;
        private final Identifier textureHighlight;
        private final Identifier textureActive;
        private final PressAction pressAction;
        private final Text narrationMessage;
        private boolean isCurrentlyVisuallyPressed = false;
        private boolean isKeyboardActivatingVisual = false;
        private boolean keyboardActionTakenThisPress = false;

        public CustomTexturedButton(int x, int y, int w, int h,
                                    Identifier textureDefault,
                                    Identifier textureHighlight,
                                    Identifier textureActive,
                                    Text narrationMessage, PressAction pressAction) {
            super(x, y, w, h, Text.empty());
            this.textureDefault = textureDefault;
            this.textureHighlight = textureHighlight;
            this.textureActive = textureActive;
            this.narrationMessage = narrationMessage;
            this.pressAction = pressAction;
        }

        @Override
        public void onPress() {
            if (this.pressAction != null) {
                this.pressAction.onPress(this);
            }
        }

        @Override
        public Text getMessage() {
            return this.narrationMessage;
        }


        @Override
        public boolean mouseClicked(double mouseX, double mouseY, int button) {
            boolean handledBySuper = super.mouseClicked(mouseX, mouseY, button);
            this.isCurrentlyVisuallyPressed = handledBySuper;
            return handledBySuper;
        }

        @Override
        public boolean mouseReleased(double mouseX, double mouseY, int button) {
            this.isCurrentlyVisuallyPressed = false;
            return super.mouseReleased(mouseX, mouseY, button);
        }

        @Override
        public void setFocused(boolean focused) {
            super.setFocused(focused);
        }

        @Override
        public void playDownSound(net.minecraft.client.sound.SoundManager soundManager) {
            soundManager.play(net.minecraft.client.sound.PositionedSoundInstance.master(net.minecraft.sound.SoundEvents.UI_BUTTON_CLICK, 1.0F));
        }

        @Override
        public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
            if (this.active && this.isFocused()) {
                if (keyCode == GLFW.GLFW_KEY_ENTER || keyCode == GLFW.GLFW_KEY_KP_ENTER || keyCode == GLFW.GLFW_KEY_SPACE) {
                    this.isKeyboardActivatingVisual = true;

                    if (!this.keyboardActionTakenThisPress) {
                        this.playDownSound(MinecraftClient.getInstance().getSoundManager());
                        if (this.pressAction != null) {
                            this.pressAction.onPress(this);
                        }
                        this.keyboardActionTakenThisPress = true;
                    }
                    return true;
                }
            }
            return super.keyPressed(keyCode, scanCode, modifiers);
        }

        public void handleKeyboardRelease(int releasedKeyCode) {
            if (releasedKeyCode == GLFW.GLFW_KEY_ENTER || releasedKeyCode == GLFW.GLFW_KEY_KP_ENTER || releasedKeyCode == GLFW.GLFW_KEY_SPACE) {
                this.isKeyboardActivatingVisual = false;
                this.keyboardActionTakenThisPress = false;
            }
        }

        @Override
        public void renderWidget(DrawContext ctx, int mouseX, int mouseY, float delta) {
            Identifier currentTextureToDraw;
            boolean isHighlighted = this.isHovered() || this.isFocused();

            if (!this.active) {
                currentTextureToDraw = this.textureDefault;
                this.isKeyboardActivatingVisual = false;
                this.keyboardActionTakenThisPress = false;
                this.isCurrentlyVisuallyPressed = false;
            } else {
                if (this.isKeyboardActivatingVisual || (this.isCurrentlyVisuallyPressed && this.isHovered())) {
                    currentTextureToDraw = this.textureActive;
                } else if (isHighlighted) {
                    currentTextureToDraw = this.textureHighlight;
                } else {
                    currentTextureToDraw = this.textureDefault;
                }
            }

            if (currentTextureToDraw == null) {
                ctx.fill(this.getX(), this.getY(), this.getX() + this.width, this.getY() + this.height, 0xFFFF00FF);
                return;
            }
            ctx.drawTexture(RenderPipelines.GUI_TEXTURED, currentTextureToDraw, this.getX(), this.getY(), 0, 0, this.width, this.height, this.width, this.height);
        }

        @Override
        protected void appendClickableNarrations(NarrationMessageBuilder nb) {
            this.appendDefaultNarrations(nb);
        }

        @FunctionalInterface
        public interface PressAction {
            void onPress(CustomTexturedButton b);
        }
    }

    public class VerticalSliderWidget extends SliderWidget {
        private final int minValue;
        private final int maxValue;
        private final Consumer<Integer> applyActionWithValue;
        private final Consumer<Integer> liveValueConsumer;
        private boolean valueChangedDuringInteraction;
        private boolean isCurrentlyDragging;
        private final Identifier thumbTextureDefault;
        private final Identifier thumbTextureFocus;
        private final int fillColor;
        private final int emptyColor;
        private final int outlineDefaultColor;
        private final int outlineHighlightColor;
        private final int outlineDisabledColor;
        private static final int THUMB_WIDTH = 16;
        private static final int THUMB_HEIGHT = 10;
        private boolean isKeyboardMoveMode = false;

        public VerticalSliderWidget(int x, int y, int trackWidth, int trackHeight,
                                    int minValue, int maxValue, int initialValue,
                                    Consumer<Integer> action,
                                    Consumer<Integer> liveValueConsumer,
                                    Identifier thumbTextureDefault,
                                    Identifier thumbTextureFocus,
                                    int fillColor, int emptyColor,
                                    int outlineDefaultColor,
                                    int outlineHighlightColor,
                                    int outlineDisabledColor) {
            super(x, y, trackWidth, trackHeight, Text.empty(), calculateNormalizedValue(initialValue, minValue, maxValue));
            this.minValue = minValue;
            this.maxValue = maxValue;
            this.applyActionWithValue = action;
            this.liveValueConsumer = liveValueConsumer;
            this.isCurrentlyDragging = false;
            this.thumbTextureDefault = thumbTextureDefault;
            this.thumbTextureFocus = thumbTextureFocus;
            this.fillColor = fillColor;
            this.emptyColor = emptyColor;
            this.outlineDefaultColor = outlineDefaultColor;
            this.outlineHighlightColor = outlineHighlightColor;
            this.outlineDisabledColor = outlineDisabledColor;
            updateMessage();
        }

        @Override
        public void setFocused(boolean focused) {
            super.setFocused(focused);
        }

        private static double calculateNormalizedValue(int actualValue, int min, int max) {
            if (max - min == 0) return 0.0;
            actualValue = MathHelper.clamp(actualValue, min, max);
            return (double) (actualValue - min) / (double) (max - min);
        }

        public void setActualValue(int val) {
            int clampedVal = MathHelper.clamp(val, this.minValue, this.maxValue);
            double normalizedVal = calculateNormalizedValue(clampedVal, this.minValue, this.maxValue);
            if (this.value != normalizedVal) {
                this.value = normalizedVal;
            }
            updateMessage();
        }

        public int getActualValue() {
            return this.minValue + (int) Math.round(this.value * (this.maxValue - this.minValue));
        }

        public boolean isCurrentlyDragging() { return this.isCurrentlyDragging; }

        @Override
        protected void updateMessage() { this.setMessage(Text.literal(String.valueOf(getActualValue()))); }

        @Override
        protected void applyValue() { if (this.applyActionWithValue != null) { this.applyActionWithValue.accept(getActualValue()); } }

        private void updateValueFromMouseY(double mouseY) {
            double normalizedValue;
            if (this.getHeight() <= THUMB_HEIGHT) {
                normalizedValue = (mouseY <= this.getY() + (double)THUMB_HEIGHT / 2.0) ? 1.0 : 0.0;
            } else {
                double effectiveTrackHeight = (double)this.getHeight() - THUMB_HEIGHT;
                double thumbCenterRelativeY = mouseY - (this.getY() + (double)THUMB_HEIGHT / 2.0);
                normalizedValue = 1.0 - (thumbCenterRelativeY / effectiveTrackHeight);
            }
            double clampedValue = MathHelper.clamp(normalizedValue, 0.0, 1.0);
            if (this.value != clampedValue) {
                this.value = clampedValue;
                updateMessage();
                this.valueChangedDuringInteraction = true;

                if (this.liveValueConsumer != null) {
                    this.liveValueConsumer.accept(getActualValue());
                }
            }
        }

        @Override
        public void onClick(double mouseX, double mouseY) {
            this.updateValueFromMouseY(mouseY);
            this.isCurrentlyDragging = true;
        }

        @Override
        protected void onDrag(double mouseX, double mouseY, double deltaX, double deltaY) {
            if (this.isCurrentlyDragging) {
                this.updateValueFromMouseY(mouseY);
            }
        }

        @Override
        public void onRelease(double mouseX, double mouseY) {
            if (this.isCurrentlyDragging) {
                if (this.valueChangedDuringInteraction) {
                    this.applyValue();
                }
                super.playDownSound(MinecraftClient.getInstance().getSoundManager());
            }
            this.isCurrentlyDragging = false;
            this.valueChangedDuringInteraction = false;
        }

        @Override
        public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
            if (this.isFocused()) {
                if (keyCode == GLFW.GLFW_KEY_ENTER || keyCode == GLFW.GLFW_KEY_KP_ENTER) {
                    this.isKeyboardMoveMode = !this.isKeyboardMoveMode;
                    return true;
                }

                if (keyCode == GLFW.GLFW_KEY_ESCAPE && this.isKeyboardMoveMode) {
                    this.isKeyboardMoveMode = false;
                    return true;
                }

                if (this.isKeyboardMoveMode) {
                    double stepSize = (this.maxValue - this.minValue > 0) ? (1.0 / (double) (this.maxValue - this.minValue)) : 0.01;
                    stepSize = Math.max(stepSize, 0.005);
                    boolean valueChanged = false;

                    if (keyCode == GLFW.GLFW_KEY_UP) {
                        this.value = MathHelper.clamp(this.value + stepSize, 0.0, 1.0);
                        valueChanged = true;
                    } else if (keyCode == GLFW.GLFW_KEY_DOWN) {
                        this.value = MathHelper.clamp(this.value - stepSize, 0.0, 1.0);
                        valueChanged = true;
                    }

                    if (valueChanged) {
                        updateMessage();
                        this.applyValue();
                        return true;
                    }
                }
            }
            return super.keyPressed(keyCode, scanCode, modifiers);
        }
        @Override
        public void renderWidget(DrawContext ctx, int mouseX, int mouseY, float delta) {
            int trackX = this.getX();
            int trackY = this.getY();
            int trackWidth = this.getWidth();
            int trackHeight = this.getHeight();

            int thumbTopRenderY = trackY + (int) Math.round((1.0 - this.value) * (double) (trackHeight - THUMB_HEIGHT));
            thumbTopRenderY = MathHelper.clamp(thumbTopRenderY, trackY, trackY + trackHeight - THUMB_HEIGHT);

            int currentOutlineColor;
            boolean isHighlighted = this.isHovered() || this.isFocused() || this.isCurrentlyDragging;

            if (!this.active) {
                currentOutlineColor = this.outlineDisabledColor;
            } else if (isHighlighted) {
                currentOutlineColor = this.outlineHighlightColor;
            } else {
                currentOutlineColor = this.outlineDefaultColor;
            }

            int filledTopYBoundary = thumbTopRenderY + THUMB_HEIGHT;

            ctx.fill(trackX, trackY, trackX + trackWidth, thumbTopRenderY, this.emptyColor);
            ctx.fill(trackX, filledTopYBoundary, trackX + trackWidth, trackY + trackHeight, this.fillColor);

            if (trackWidth > 0 && trackHeight > 0) {
                ctx.fill(trackX, trackY, trackX + trackWidth, trackY + 1, currentOutlineColor);
                ctx.fill(trackX, trackY + trackHeight - 1, trackX + trackWidth, trackY + trackHeight, currentOutlineColor);
                if (trackHeight > 2) {
                    ctx.fill(trackX, trackY + 1, trackX + 1, trackY + trackHeight - 1, currentOutlineColor);
                    if (trackWidth > 1) {
                        ctx.fill(trackX + trackWidth - 1, trackY + 1, trackX + trackWidth, trackY + trackHeight - 1, currentOutlineColor);
                    }
                }
            }
            Identifier currentThumbTexture;
            if (this.isKeyboardMoveMode) {
                currentThumbTexture = this.thumbTextureFocus;
            } else {
                currentThumbTexture = this.thumbTextureDefault;
            }

            if (currentThumbTexture == null) {
                currentThumbTexture = this.thumbTextureDefault;
            }

            int currentThumbX = this.getX() + (this.getWidth() - THUMB_WIDTH) / 2;
            int currentThumbTopRenderY = this.getY() + (int) Math.round((1.0 - this.value) * (double) (this.getHeight() - THUMB_HEIGHT));
            currentThumbTopRenderY = MathHelper.clamp(currentThumbTopRenderY, this.getY(), this.getY() + this.getHeight() - THUMB_HEIGHT);
            if (currentThumbTexture != null) {
                ctx.drawTexture(RenderPipelines.GUI_TEXTURED, currentThumbTexture, currentThumbX, currentThumbTopRenderY, 0, 0, THUMB_WIDTH, THUMB_HEIGHT, THUMB_WIDTH, THUMB_HEIGHT);
            } else {
                ctx.fill(currentThumbX, currentThumbTopRenderY, currentThumbX + THUMB_WIDTH, currentThumbTopRenderY + THUMB_HEIGHT, 0xFFFF00FF);
            }
        }
        @Override
        public void appendClickableNarrations(NarrationMessageBuilder builder) {
            builder.put(NarrationPart.TITLE, this.getMessage());
            if (this.active) {
                if (this.isFocused()) {
                    builder.put(NarrationPart.USAGE, Text.translatable("narration.slider.usage.focused"));
                } else {
                    builder.put(NarrationPart.USAGE, Text.translatable("narration.slider.usage.hovered"));
                }
            }
        }
    }

    public class ValueTextFieldWidget extends TextFieldWidget {
        private final Consumer<String> onValueFinalized;
        private String lastSubmittedText;
        private final Identifier textureDefault;
        private final Identifier textureHighlight;

        private boolean isCurrentlyEditable = true;
        public ValueTextFieldWidget(TextRenderer textRendererFromScreen, int x, int y, int width, int height, Text messageForNarration,
                                    Consumer<String> onValueFinalized,
                                    Identifier textureDefault,
                                    Identifier textureHighlight
        ) {
            super(textRendererFromScreen, x, y, width, height, messageForNarration);
            this.onValueFinalized = onValueFinalized;
            this.lastSubmittedText = "";
            this.textureDefault = textureDefault;
            this.textureHighlight = textureHighlight;
            this.setDrawsBackground(false);
            this.setCentered(true);
            this.setTextShadow(false);
            this.setEditableColor(TEXT_FIELD_FONT_COLOR);
        }

        @Override
        public void setEditable(boolean editable) {
            super.setEditable(editable);
            this.isCurrentlyEditable = editable;
        }

        @Override
        public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
            if (!this.isFocused()) { return false; }

            if (keyCode == GLFW.GLFW_KEY_ENTER || keyCode == GLFW.GLFW_KEY_KP_ENTER) {
                if (this.onValueFinalized != null) {
                    this.onValueFinalized.accept(this.getText());
                    this.lastSubmittedText = this.getText();
                }
                this.setFocused(false);
                return true;
            }
            if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
                this.setText(this.lastSubmittedText);
                this.setFocused(false);
                return true;
            }
            return super.keyPressed(keyCode, scanCode, modifiers);
        }

        public void setTextFromServer(String newTextFromHandler) {
            String currentDisplayedText = this.getText();
            if (!Objects.equals(currentDisplayedText, newTextFromHandler)) {
                super.setText(newTextFromHandler);
            }
            this.lastSubmittedText = newTextFromHandler;
        }
        @Override
        public void renderWidget(DrawContext context, int mouseX, int mouseY, float delta) {
            if (!this.isVisible()) {
                return;
            }

            Identifier currentTextureToDraw = getBackgroundTexture(mouseX, mouseY);

            context.drawTexture(RenderPipelines.GUI_TEXTURED, currentTextureToDraw, this.getX(), this.getY(), 0, 0, this.width, this.height, this.width, this.height);

            int verticalTextOffset = (this.getHeight() - 8) / 2;

            context.getMatrices().pushMatrix();
            context.getMatrices().translate(0.0F, verticalTextOffset);

            super.renderWidget(context, mouseX, mouseY, delta);

            context.getMatrices().popMatrix();
        }

        private Identifier getBackgroundTexture(int mouseX, int mouseY) {
            if (!this.isCurrentlyEditable) {
                return this.textureDefault;
            }

            boolean mouseIsOver = this.isMouseOver(mouseX, mouseY);

            if (mouseIsOver) {
                return this.textureHighlight;
            } else {
                return this.textureDefault;
            }
        }

        public void setTextFromSliderDrag(String newText) {
            if (!Objects.equals(this.getText(), newText)) {
                super.setText(newText);

            }
        }

        @Override
        public void appendClickableNarrations(NarrationMessageBuilder builder) {
            super.appendClickableNarrations(builder);

        }
    }
}